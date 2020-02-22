package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Bank;

import java.util.List;
import java.util.Map;

/**
 * @author baogang
 */
public interface BankService extends IService<Bank> {

    /**
     * 查询所有银行
     * @return
     */
    List<Map<String, Object>> findAllBanks();

    /**
     * 根据银行总行ID以及输入查询支行信息
     * @param bankId
     * @param input
     * @return
     */
    List<Map<String, Object>> findSubbranchesByBankIdAndName(String bankId, String input);
}
