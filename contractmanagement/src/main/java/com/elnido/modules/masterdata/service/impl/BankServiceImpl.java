package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Bank;
import com.elnido.modules.masterdata.mapper.BankMapper;
import com.elnido.modules.masterdata.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baogang
 */
@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements BankService {

    @Override
    public List<Bank> findAllBanks() {
        Wrapper<Bank> bankWrapper = Wrappers.<Bank>lambdaQuery().select(Bank::getBankId, Bank::getBankName).groupBy(Bank::getBankId).groupBy(Bank::getBankName);
        List<Bank> bankList = this.getBaseMapper().selectList(bankWrapper);
        return bankList;
    }

    @Override
    public List<Bank> findSubbranchesByBankId(String bankId) {
        Wrapper<Bank> bankWrapper = Wrappers.<Bank>lambdaQuery().select(Bank::getSubBranchId, Bank::getSubBranchName)
                .eq(Bank::getBankId, bankId).orderBy(true, true, Bank::getSubBranchName);
        List<Bank> subBranchList = this.getBaseMapper().selectList(bankWrapper);
        return subBranchList;
    }
}
