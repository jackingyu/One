package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Bank;
import com.elnido.modules.masterdata.mapper.BankMapper;
import com.elnido.modules.masterdata.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author baogang
 */
@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements BankService {

    @Override
    public List<Map<String, Object>> findAllBanks() {
        Wrapper<Bank> bankWrapper = Wrappers.<Bank>lambdaQuery().select(Bank::getBankId, Bank::getBankName).groupBy(Bank::getBankId).groupBy(Bank::getBankName);
        List<Map<String, Object>> bankList = this.getBaseMapper().selectMaps(bankWrapper);
        return bankList;
    }

    @Override
    public List<Map<String, Object>> findSubbranchesByBankIdAndName(String bankId, String input) {
        Wrapper<Bank> bankWrapper =
                Wrappers.<Bank>lambdaQuery().select(Bank::getBankId, Bank::getSubBranchId, Bank::getSubBranchName)
                .eq(Bank::getBankId, bankId)
                .like(Bank::getSubBranchName, input)
                .orderBy(true, true, Bank::getSubBranchName)
                .last("limit 0, 20");
        List<Map<String, Object>> subBranchList = this.getBaseMapper().selectMaps(bankWrapper);
        return subBranchList;
    }
}
