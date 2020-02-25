package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.model.CompanyPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.CompanyService;
import com.elnido.modules.util.ElnidoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.elnido.modules.Constants.I18N.General.RECORD_NOT_EXIST_KEY;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "公司维护")
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private MessageUtils messageUtils;

    @Resource
    private CompanyService companyService;

    @Resource
    private BankAccountService bankAccountService;

    @GetMapping
    @ApiOperation(value = "公司表-按条件查询公司信息", notes = "公司表-按条件查询公司")
    public Result<CompanyPage<Company>> pagedSearchCompanies(@RequestParam(name = "companyName") String companyName,
                                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<CompanyPage<Company>> result = new Result<>();
        CompanyPage<Company> companyPage = new CompanyPage(pageNo, pageSize);
        companyPage.setCompanyName(ElnidoUtil.handleJeecgFuzzySearchString(companyName));

        CompanyPage<Company> queriedCompanyPage = companyService.findPagedCompanies(companyPage);
        result.setResult(queriedCompanyPage);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "公司表-按ID查询公司全部信息", notes = "公司表-按ID查询公司全部信息")
    public Result<?> queryCompanyInfoById(@PathVariable String id) {
        Result<Company> result = new Result<>();

        LambdaQueryWrapper<Company> companyLambdaQueryWrapper
                = Wrappers.<Company>lambdaQuery().eq(Company::getId, id);
        int count = companyService.count(companyLambdaQueryWrapper);
        if (count == 0) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }
        Company company = companyService.findCompanyWithBankAccountById(id);
        result.setResult(company);
        result.setSuccess(true);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "公司表-新建公司信息", notes = "公司表-新建公司")
    public Result<Company> createCompany(@RequestBody Company company) {
        Result<Company> result = new Result<>();
        boolean created = companyService.createCompany(company);
        if(created) {
            result.setResult(company);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }

    @DeleteMapping("/bankaccount/{bankAccountId}")
    @ApiOperation(value = "公司表-删除公司银行账户信息", notes = "公司表-删除公司银行账户信息")
    public Result<?> deleteBank(@PathVariable String bankAccountId) {
        Result<Boolean> result = new Result<>();
        LambdaQueryWrapper<BankAccount> bankAccountLambdaQueryWrapper
                = Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getId, bankAccountId);
        int count = bankAccountService.count(bankAccountLambdaQueryWrapper);
        if (count == 0) {
            return Result.error(HttpStatus.NOT_FOUND.value(), messageUtils.get(RECORD_NOT_EXIST_KEY));
        }
        boolean deleted = bankAccountService.removeBankAccountByBankAccountIdAndPartnerType(bankAccountId, PartnerTypeEnum.COMPANY);
        result.setSuccess(deleted);
        result.setResult(deleted);

        return result;
    }

}
