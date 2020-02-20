package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Customer;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.model.VendorPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.CustomerService;
import com.elnido.modules.masterdata.service.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.elnido.modules.masterdata.Constants.I18N.General.RECORD_NOT_EXIST_KEY;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "客户维护")
@RestController
@RequestMapping("/masterdata/customers")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @Resource
    private BankAccountService bankAccountService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping("/")
    @ApiOperation(value = "客户表-按条件查询客户信息", notes = "客户表-按条件查询客户")
    public Result<IPage<Customer>> pagedSearchVendors(@RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<IPage<Customer>> result = new Result<>();

        IPage<Customer> customerIPage = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<Customer> lambdaQueryWrapper = Wrappers.<Customer>lambdaQuery().like(Customer::getName, name);
        IPage<Customer> queriedCustomerPage = customerService.page(customerIPage, lambdaQueryWrapper);
        result.setResult(queriedCustomerPage);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/")
    @ApiOperation(value = "客户表-新建客户信息", notes = "客户表-新建客户")
    public Result<Customer> createCompany(@RequestBody @Valid Customer customer) {
        Result<Customer> result = new Result<>();
        boolean created = customerService.createCustomer(customer);
        if(created) {
            result.setResult(customer);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @DeleteMapping("/bankaccount/{bankAccountId}")
    @ApiOperation(value = "客户表-删除客户银行账户信息", notes = "客户表-删除客户银行账户信息")
    public Result<?> deleteBank(@PathVariable String bankAccountId) {
        Result<Boolean> result = new Result<>();
        LambdaQueryWrapper<BankAccount> bankAccountLambdaQueryWrapper
                = Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getId, bankAccountId);
        int count = bankAccountService.count(bankAccountLambdaQueryWrapper);
        if (count == 0) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }
        boolean deleted = bankAccountService.removeBankAccountByBankAccountIdAndPartnerType(bankAccountId, PartnerTypeEnum.CUSTOMER);
        result.setSuccess(deleted);
        result.setResult(deleted);

        return result;
    }
}
