package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.mapper.BankAccountMapper;
import com.elnido.modules.masterdata.mapper.Partner2BankAccountMapper;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.Partner2BankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baogang
 */
@Service
public class Partner2BankAccountServiceImpl extends ServiceImpl<Partner2BankAccountMapper, Partner2BankAccount> implements Partner2BankAccountService {

    @Override
    public List<Partner2BankAccount> findPartner2BankAccountRelByPartnerId(String partnerId) {
        LambdaQueryWrapper<Partner2BankAccount> lambdaQueryWrapper =
                Wrappers.<Partner2BankAccount>lambdaQuery().eq(Partner2BankAccount::getPartnerId, partnerId);
        return this.list(lambdaQueryWrapper);
    }

    @Override
    public boolean removePartner2BankAccountRelByBankAccountId(String bankAccountId) {
        LambdaQueryWrapper<Partner2BankAccount> partner2BankAccountLambdaQueryWrapper =
                Wrappers.<Partner2BankAccount>lambdaQuery().eq(Partner2BankAccount::getBankAccountId, bankAccountId);
        return this.remove(partner2BankAccountLambdaQueryWrapper);
    }
}
