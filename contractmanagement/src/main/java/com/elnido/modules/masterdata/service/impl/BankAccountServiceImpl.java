package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.mapper.BankAccountMapper;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.Partner2BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author baogang
 */
@Service
public class BankAccountServiceImpl extends ServiceImpl<BankAccountMapper, BankAccount> implements BankAccountService {

    @Resource
    private Partner2BankAccountService partner2BankAccountService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeBankAccountByBankAccountIdAndPartnerType(String bankAccountId, PartnerTypeEnum partnerTypeEnum) {
        LambdaQueryWrapper<BankAccount> lambdaQueryWrapper =
                Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getId, bankAccountId);
        boolean removeBankAccounts = this.remove(lambdaQueryWrapper);

        LambdaQueryWrapper<Partner2BankAccount> partner2BankAccountLambdaQueryWrapper =
                Wrappers.<Partner2BankAccount>lambdaQuery().eq(Partner2BankAccount::getBankAccountId, bankAccountId)
                .eq(Partner2BankAccount::getPartnerType, partnerTypeEnum);

        boolean removePartner2BankAccountRel = partner2BankAccountService.remove(partner2BankAccountLambdaQueryWrapper);
        return removeBankAccounts && removePartner2BankAccountRel;
    }
}
