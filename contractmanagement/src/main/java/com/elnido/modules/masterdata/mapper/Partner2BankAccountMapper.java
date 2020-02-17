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
    @Select(" SELECT b.*,mainbank.bank_name, banks.sub_branch_name " +
            " FROM partner_bankaccount_rel p " +
            " LEFT JOIN bank_account b ON p.bank_account_id=b.id " +
            " LEFT JOIN (select bank_id, bank_name from banks group by bank_id, bank_name) mainbank ON b.bank_id=mainbank.bank_id " +
            " LEFT JOIN banks ON b.sub_branch_id=banks.sub_branch_id " +
            " WHERE partner_id=#{id} and partner_type=1 ")
    List<BankAccount> findBankAccountsByCompanyId(String id);
}
