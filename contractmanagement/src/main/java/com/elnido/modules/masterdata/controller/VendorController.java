package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.elnido.modules.masterdata.Constants.I18N.General.RECORD_NOT_EXIST_KEY;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "供应商维护")
@RestController
@RequestMapping("/masterdata/vendors")
public class VendorController {

    @Resource
    private VendorService vendorService;

    @Resource
    private BankAccountService bankAccountService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping("/")
    @ApiOperation(value = "供应商表-按条件查询供应商信息", notes = "供应商表-按条件查询供应商")
    public Result<IPage<Vendor>> pagedSearchVendors(@RequestParam(name = "vendorGroupCode", required = false) String vendorGroupCode,
                                                         @RequestParam(name = "vendorName", required = false) String vendorName,
                                                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<IPage<Vendor>> result = new Result<>();
        IPage<Vendor> iPage = new Page(pageNo, pageSize);
        LambdaQueryWrapper<Vendor> lambdaQueryWrapper =
                Wrappers.<Vendor>lambdaQuery().like(StringUtils.isNotBlank(vendorName), Vendor::getVendorName, vendorName)
                .eq(StringUtils.isNotBlank(vendorGroupCode), Vendor::getVendorGroupCode, vendorGroupCode);
        IPage<Vendor> pagedVendor = vendorService.page(iPage, lambdaQueryWrapper);
        result.setResult(pagedVendor);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/")
    @ApiOperation(value = "供应商表-新建供应商信息", notes = "供应商表-新建供应商")
    public Result<Vendor> createCompany(@RequestBody Vendor vendor) {
        Result<Vendor> result = new Result<>();
        boolean created = vendorService.createVendor(vendor);
        if(created) {
            result.setResult(vendor);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @DeleteMapping("/bankaccount/{bankAccountId}")
    @ApiOperation(value = "供应商表-删除供应商银行账户信息", notes = "供应商表-删除供应商银行账户信息")
    public Result<?> deleteBank(@PathVariable String bankAccountId) {
        Result<Boolean> result = new Result<>();
        LambdaQueryWrapper<BankAccount> bankAccountLambdaQueryWrapper
                = Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getId, bankAccountId);
        int count = bankAccountService.count(bankAccountLambdaQueryWrapper);
        if (count == 0) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }
        boolean deleted = bankAccountService.removeBankAccountByBankAccountIdAndPartnerType(bankAccountId, PartnerTypeEnum.VENDOR);
        result.setSuccess(deleted);
        result.setResult(deleted);

        return result;
    }
}
