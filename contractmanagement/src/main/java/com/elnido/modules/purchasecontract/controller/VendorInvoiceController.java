package com.elnido.modules.purchasecontract.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.purchasecontract.entity.VendorInvoice;
import com.elnido.modules.purchasecontract.service.VendorInvoiceService;
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
@Api(tags = "供应商发票维护")
@RestController
@RequestMapping("/vendorinvoices")
public class VendorInvoiceController {

    @Resource
    private VendorInvoiceService vendorInvoiceService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping
    @ApiOperation(value = "供应商发票表-分页查询供应商发票", notes = "供应商发票表-分页查询供应商发票")
    public Result<IPage<VendorInvoice>> findPagedVendorInvoice(VendorInvoice vendorInvoice,
                                                              @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                              HttpServletRequest httpServletRequest) {
        Result<IPage<VendorInvoice>> result = new Result<>();
        IPage<VendorInvoice> vendorInvoicePage = new Page(pageNo, pageSize);

        QueryWrapper<VendorInvoice> queryWrapper = QueryGenerator.initQueryWrapper(vendorInvoice, httpServletRequest.getParameterMap());
        IPage<VendorInvoice> queriedVendorInvoices = vendorInvoiceService.page(vendorInvoicePage, queryWrapper);

        result.setResult(queriedVendorInvoices);
        result.setSuccess(true);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "供应商发票表-创建供应商发票", notes = "供应商发票表-创建供应商发票")
    public Result<?> createVendorInvoice(@RequestBody @Validated({InsertValidation.class}) VendorInvoice vendorInvoice) {
        Result<Object> result = new Result<>();
        boolean created = vendorInvoiceService.save(vendorInvoice);

        result.setResult(vendorInvoice);
        result.setSuccess(created);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "供应商发票表-查询供应商发票", notes = "供应商发票表-查询供应商发票")
    public Result<?> findVendorInvoice(@PathVariable String id) {
        Result<Object> result = new Result<>();

        VendorInvoice vendorInvoice = vendorInvoiceService.getById(id);
        if (Objects.isNull(vendorInvoice)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        result.setResult(vendorInvoice);
        result.setSuccess(true);
        return result;
    }


    @PutMapping
    @ApiOperation(value = "供应商发票表-更新供应商发票", notes = "供应商发票表-更新供应商发票")
    public Result<?> updateVendorInvoice(@RequestBody @Validated(UpdateValidation.class) VendorInvoice vendorInvoice) {
        Result<Object> result = new Result<>();

        String vendorInvoiceId = vendorInvoice.getId();
        VendorInvoice queriedVendorInvoice = vendorInvoiceService.getById(vendorInvoiceId);
        if (Objects.isNull(queriedVendorInvoice)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        boolean updated = vendorInvoiceService.updateById(vendorInvoice);
        if (updated) {
            result.setResult(vendorInvoice);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "供应商发票表-删除供应商发票", notes = "供应商发票表-删除供应商发票")
    public Result<?> deleteVendorInvoice(@PathVariable String id) {
        Result<Object> result = new Result<>();

        VendorInvoice vendorInvoice = vendorInvoiceService.getById(id);
        if (Objects.isNull(vendorInvoice)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        boolean deleted = vendorInvoiceService.removeById(id);
        result.setResult(deleted);
        result.setSuccess(true);
        return result;
    }

}
