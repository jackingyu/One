package com.elnido.modules.purchasecontract.controller;

import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;
import com.elnido.modules.purchasecontract.data.PurchaseContractPage;
import com.elnido.modules.purchasecontract.service.PurchaseContractItemService;
import com.elnido.modules.purchasecontract.service.PurchaseContractService;
import com.elnido.modules.util.ElnidoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

import static com.elnido.modules.Constants.I18N.General.RECORD_NOT_EXIST_KEY;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "采购合同维护")
@RestController
@RequestMapping("/purchasecontracts")
public class PurchaseContractController {

    @Resource
    private PurchaseContractService purchaseContractService;

    @Resource
    private PurchaseContractItemService purchaseContractItemService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping
    @ApiOperation(value = "采购合同表-按条件分页查询采购合同", notes = "采购合同表-按条件分页查询采购合同")
    public Result<PurchaseContractPage<PurchaseContract>> findPagedPurchaseContract(@RequestParam(name = "projectId", required = false) String projectId,
                                                                                    @RequestParam(name = "contractTypeCode", required = false) Integer contractTypeCode,
                                                                                    @RequestParam(name = "vendorName", required = false) String vendorName,
                                                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<PurchaseContractPage<PurchaseContract>> result = new Result<>();
        PurchaseContractPage<PurchaseContract> purchaseContractPage = new PurchaseContractPage(pageNo, pageSize);
        purchaseContractPage.setProjectId(projectId);
        purchaseContractPage.setContractTypeCode(contractTypeCode);
        purchaseContractPage.setVendorName(ElnidoUtil.handleJeecgFuzzySearchString(vendorName));

        PurchaseContractPage<PurchaseContract> pagedPurchaseContractHeaders =
                purchaseContractService.findPagedPurchaseContractHeaders(purchaseContractPage);

        result.setResult(pagedPurchaseContractHeaders);
        result.setSuccess(true);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "采购合同表-创建采购合同", notes = "采购合同表-创建采购合同")
    public Result<?> createPurchaseContract(@RequestBody PurchaseContract purchaseContract) {
        Result<Object> result = new Result<>();
        boolean createdPurchaseContract = purchaseContractService.createPurchaseContract(purchaseContract);
        if (createdPurchaseContract) {
            result.setResult(purchaseContract);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "采购合同表-按采购合同ID查询采购合同详细信息", notes = "采购合同表-按采购合同ID查询采购合同详细信息")
    public Result<?> findPurchaseContractDetail(@PathVariable String id) {
        Result<PurchaseContract> result = new Result<>();
        PurchaseContract purchaseContract = purchaseContractService.findAssociatedPurchaseContractInfoById(id);

        if (Objects.isNull(purchaseContract)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }
        result.setResult(purchaseContract);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/item/{itemId}")
    @ApiOperation(value = "采购合同行项目表-按采购合同行项目ID查询采购合同行项目", notes = "采购合同行项目表-按采购合同行项目ID查询采购合同行项目")
    public Result<?> findPurchaseContractItem(@PathVariable String itemId) {
        Result<PurchaseContractItem> result = new Result<>();

        PurchaseContractItem purchaseContractItem = purchaseContractItemService.findAssociatedPurchaseContractItemById(itemId);

        if (Objects.isNull(purchaseContractItem)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }
        result.setResult(purchaseContractItem);
        result.setSuccess(true);
        return result;
    }

    @PutMapping("/item")
    @ApiOperation(value = "采购合同行项目表-更新采购合同行项目", notes = "采购合同行项目表-更新采购合同行项目")
    public Result<?> updatePurchaseContractItem(@RequestBody @Valid PurchaseContractItem purchaseContractItem) {
        Result<PurchaseContractItem> result = new Result<>();

        String itemId = purchaseContractItem.getId();
        if (!checkPurchaseContractorItemExist(itemId)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        boolean updated = purchaseContractItemService.update(purchaseContractItem, null);
        if (updated) {
            result.setResult(purchaseContractItem);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }

    @DeleteMapping("/item/{itemId}")
    @ApiOperation(value = "采购合同行项目表-更新采购合同行项目", notes = "采购合同行项目表-更新采购合同行项目")
    public Result<?> deletePurchaseContractItemByItemId(@PathVariable String itemId) {
        Result<Boolean> result = new Result<>();

        if (!checkPurchaseContractorItemExist(itemId)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        boolean deleted = purchaseContractItemService.removeById(itemId);
        result.setResult(deleted);
        result.setSuccess(deleted);

        return result;
    }

    private boolean checkPurchaseContractorItemExist(String itemId) {
        PurchaseContractItem queriedPurchaseContractItem = purchaseContractItemService.getById(itemId);
        return Objects.nonNull(queriedPurchaseContractItem);
    }

}
