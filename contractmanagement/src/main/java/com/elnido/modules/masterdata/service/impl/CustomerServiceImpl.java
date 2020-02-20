package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Customer;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.mapper.CustomerMapper;
import com.elnido.modules.masterdata.mapper.VendorMapper;
import com.elnido.modules.masterdata.model.VendorPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.CustomerService;
import com.elnido.modules.masterdata.service.Partner2BankAccountService;
import com.elnido.modules.masterdata.service.VendorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author baogang
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Resource
    private BankAccountService bankAccountService;

    @Resource
    private Partner2BankAccountService partner2BankAccountService;

    @Resource
    private CustomerMapper customerMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createCustomer(Customer customer) {
        boolean saveCustomer = this.save(customer);
        if (Objects.nonNull(customer.getBankAccounts())) {
            boolean saveBankAccount = bankAccountService.saveBatch(customer.getBankAccounts());

            final String createdCustomerId = customer.getId();
            List<Partner2BankAccount> partner2BankAccountList = customer.getBankAccounts().stream()
                    .map(bankAccount -> {
                        Partner2BankAccount partner2BankAccount = new Partner2BankAccount();
                        partner2BankAccount.setPartnerId(createdCustomerId);
                        partner2BankAccount.setBankAccountId(bankAccount.getId());
                        partner2BankAccount.setPartnerType(PartnerTypeEnum.CUSTOMER);
                        return partner2BankAccount;
                    })
                    .collect(Collectors.toList());

            boolean saveRelation = partner2BankAccountService.saveBatch(partner2BankAccountList);
            return saveCustomer && saveBankAccount && saveRelation;
        }

        return saveCustomer;
    }
}
