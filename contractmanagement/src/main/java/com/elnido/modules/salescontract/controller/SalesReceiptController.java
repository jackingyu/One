package com.elnido.modules.salescontract.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.purchasecontract.entity.VendorPayment;
import com.elnido.modules.salescontract.entity.SalesReceipt;
import com.elnido.modules.salescontract.service.SalesReceiptService;
import com.elnido.modules.validation.InsertValidation;
import com.elnido.modules.validation.UpdateValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static com.elnido.modules.Constants.I18N.General.RECORD_NOT_EXIST_KEY;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "销售开票维护")
@RestController
@RequestMapping("/salesreceipts")
public class SalesReceiptController {

    @Resource
    private SalesReceiptService salesReceiptService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping
    @ApiOperation(value = "销售开票表-分页查询销售开票", notes = "供应商付款表-分页查询供应商付款")
    public Result<IPage<SalesReceipt>> findPagedSalesReceipt(SalesReceipt salesReceipt,
                                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                             HttpServletRequest httpServletRequest) {
        Result<IPage<SalesReceipt>> result = new Result<>();
        IPage<SalesReceipt> salesReceiptPage = new Page(pageNo, pageSize);

        QueryWrapper<SalesReceipt> queryWrapper = QueryGenerator.initQueryWrapper(salesReceipt, httpServletRequest.getParameterMap());
        IPage<SalesReceipt> queriedSalesReceipts = salesReceiptService.page(salesReceiptPage, queryWrapper);

        result.setResult(queriedSalesReceipts);
        result.setSuccess(true);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "销售开票表-创建销售开票", notes = "销售开票表-创建销售开票")
    public Result<?> createSalesReceipt(@RequestBody @Validated({InsertValidation.class}) SalesReceipt salesReceipt) {
        Result<Object> result = new Result<>();
        boolean created = salesReceiptService.save(salesReceipt);

        result.setResult(salesReceipt);
        result.setSuccess(created);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "销售开票表-查询销售开票", notes = "销售开票表-查询销售开票")
    public Result<?> findSalesReceipt(@PathVariable String id) {
        Result<Object> result = new Result<>();

        SalesReceipt salesReceipt = salesReceiptService.getById(id);
        if (Objects.isNull(salesReceipt)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        result.setResult(salesReceipt);
        result.setSuccess(true);
        return result;
    }

    @PutMapping
    @ApiOperation(value = "销售开票表-更新销售开票", notes = "销售开票表-更新销售开票")
    public Result<?> updateSalesReceipt(@RequestBody @Validated(UpdateValidation.class) SalesReceipt salesReceipt) {
        Result<Object> result = new Result<>();

        String salesReceiptId = salesReceipt.getId();
        SalesReceipt queriedSalesReceipt = salesReceiptService.getById(salesReceiptId);
        if (Objects.isNull(queriedSalesReceipt)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        boolean updated = salesReceiptService.updateById(salesReceipt);
        if (updated) {
            result.setResult(salesReceipt);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }

}
