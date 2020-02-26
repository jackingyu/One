package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.mapper.CompanyMapper;
import com.elnido.modules.masterdata.data.CompanyPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.CompanyService;
import com.elnido.modules.masterdata.service.Partner2BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author baogang
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Resource
    private BankAccountService bankAccountService;

    @Resource
    private Partner2BankAccountService partner2BankAccountService;

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public CompanyPage<Company> findPagedCompanies(CompanyPage<Company> companyPage) {
        return companyMapper.findPagedCompanies(companyPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createCompany(Company company) {
        boolean saveBankAccount = false;
        boolean saveCompany = this.save(company);
        if (Objects.nonNull(company.getBankAccounts())) {
            saveBankAccount = bankAccountService.saveBatch(company.getBankAccounts());
        }

        final String createdCompanyId = company.getId();

        List<Partner2BankAccount> partner2BankAccountList = company.getBankAccounts().stream()
                .map(bankAccount -> {
                    Partner2BankAccount partner2BankAccount = new Partner2BankAccount();
                    partner2BankAccount.setPartnerId(createdCompanyId);
                    partner2BankAccount.setBankAccountId(bankAccount.getId());
                    partner2BankAccount.setPartnerType(PartnerTypeEnum.COMPANY);
                    return partner2BankAccount;
                })
                .collect(Collectors.toList());
        boolean saveRelation = partner2BankAccountService.saveBatch(partner2BankAccountList);
        return saveCompany && saveBankAccount && saveRelation;
    }

    @Override
    public Company findCompanyWithBankAccountById(String companyId) {
        return companyMapper.findCompanyWithBankAccounts(companyId);
    }
}
