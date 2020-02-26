package com.elnido.modules.purchasecontract.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.purchasecontract.entity.VendorPayment;
import com.elnido.modules.purchasecontract.service.VendorPaymentService;
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
@Api(tags = "供应商付款维护")
@RestController
@RequestMapping("/vendorpayments")
public class VendorPaymentController {

    @Resource
    private VendorPaymentService vendorPaymentService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping()
    @ApiOperation(value = "供应商付款表-分页查询供应商付款", notes = "供应商付款表-分页查询供应商付款")
    public Result<IPage<VendorPayment>> findPagedVendorPayment(VendorPayment vendorPayment,
                                                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               HttpServletRequest httpServletRequest) {
        Result<IPage<VendorPayment>> result = new Result<>();
        IPage<VendorPayment> vendorPaymentPage = new Page(pageNo, pageSize);

        QueryWrapper<VendorPayment> queryWrapper = QueryGenerator.initQueryWrapper(vendorPayment, httpServletRequest.getParameterMap());
        IPage<VendorPayment> queriedVendorPayments = vendorPaymentService.page(vendorPaymentPage, queryWrapper);

        result.setResult(queriedVendorPayments);
        result.setSuccess(true);
        return result;
    }

    @PostMapping()
    @ApiOperation(value = "供应商付款表-创建供应商付款", notes = "供应商付款表-创建供应商付款")
    public Result<?> createVendorPayment(@RequestBody @Validated({InsertValidation.class}) VendorPayment vendorPayment) {
        Result<Object> result = new Result<>();
        boolean created = vendorPaymentService.save(vendorPayment);

        result.setResult(vendorPayment);
        result.setSuccess(created);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "供应商付款表-查询供应商付款", notes = "供应商付款表-查询供应商付款")
    public Result<?> findVendorPayment(@PathVariable String id) {
        Result<Object> result = new Result<>();

        VendorPayment vendorPayment = vendorPaymentService.getById(id);
        if (Objects.isNull(vendorPayment)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        result.setResult(vendorPayment);
        result.setSuccess(true);
        return result;
    }

    @PutMapping()
    @ApiOperation(value = "供应商付款表-更新供应商付款", notes = "供应商付款表-更新供应商付款")
    public Result<?> updateVendorPayment(@RequestBody @Validated(UpdateValidation.class) VendorPayment vendorPayment) {
        Result<Object> result = new Result<>();

        String vendorPaymentId = vendorPayment.getId();
        VendorPayment queriedVendorPayment = vendorPaymentService.getById(vendorPaymentId);
        if (Objects.isNull(queriedVendorPayment)) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }

        boolean updated = vendorPaymentService.updateById(vendorPayment);
        if (updated) {
            result.setResult(vendorPayment);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }

}
