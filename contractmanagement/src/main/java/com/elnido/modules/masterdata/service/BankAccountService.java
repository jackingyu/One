package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Bank;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;

import java.util.List;

/**
 * @author baogang
 */
public interface BankAccountService extends IService<BankAccount> {

    /**
     * 按银行账户ID删除账户信息以及关系表信息
     * @param bankAccountId
     * @param partnerTypeEnum
     * @return
     */
    boolean removeBankAccountByBankAccountIdAndPartnerType(String bankAccountId, PartnerTypeEnum partnerTypeEnum);
}
