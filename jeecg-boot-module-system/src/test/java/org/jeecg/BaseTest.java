package org.jeecg;

import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Company;

import java.util.ArrayList;

public abstract class BaseTest {

    protected Company createMockCompany(String companyCode, String companyName) {
        Company company = new Company();
        company.setCompanyCode(companyCode);
        company.setCompanyName(companyName);
        company.setBankAccounts(new ArrayList<>());
        return company;
    }

    protected BankAccount createMockBankAccount(String bankId, String subBranchId, String bankAccount, String bankAccountName) {
        BankAccount result = new BankAccount();
        result.setBankId(bankId);
        result.setSubBranchId(subBranchId);
        result.setBankAccount(bankAccount);
        result.setBankAccountName(bankAccountName);
        return result;
    }
}
