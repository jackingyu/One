package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author baogang
 */
public interface Partner2BankAccountMapper extends BaseMapper<Partner2BankAccount> {

    /**
     * 根据公司ID查询对应的银行账户
     * @param id
     * @return
     */
    List<BankAccount> findBankAccountsByCompanyId(String id);

    /**
     * 根据供应商ID查询对应的银行账户
     * @param id
     * @return
     */
    List<BankAccount> findBankAccountsByVendorId(String id);
}
