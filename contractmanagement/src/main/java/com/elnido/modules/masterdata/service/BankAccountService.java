package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Bank;
import com.elnido.modules.masterdata.entity.BankAccount;

import java.util.List;

/**
 * @author baogang
 */
public interface BankAccountService extends IService<BankAccount> {

    /**
     * 按银行账户ID删除账户
     * @param bankAccountId
     * @return
     */
    boolean removeBankAccountByBankAccountId(String bankAccountId);
}
