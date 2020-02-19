package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Bank;

import java.util.List;

/**
 * @author baogang
 */
public interface BankService extends IService<Bank> {

    /**
     * 查询所有银行
     * @return
     */
    List<Bank> findAllBanks();

    /**
     * 根据银行ID查询其下属支行
     * @param bankId
     * @return
     */
    List<Bank> findSubbranchesByBankId(String bankId);
}
