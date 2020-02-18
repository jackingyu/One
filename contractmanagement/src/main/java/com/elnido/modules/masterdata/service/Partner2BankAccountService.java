package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;

import java.util.List;

/**
 * @author baogang
 */
public interface Partner2BankAccountService extends IService<Partner2BankAccount> {

    /**
     * 根据合作伙伴ID查询伙伴-银行账号关系
     * @param partnerId
     * @return
     */
    List<Partner2BankAccount> findPartner2BankAccountRelByPartnerId(String partnerId);

    /**
     * 按照银行账户ID删除伙伴-银行账号关系
     * @param bankAccountId
     * @return
     */
    boolean removePartner2BankAccountRelByBankAccountId(String bankAccountId);
}
