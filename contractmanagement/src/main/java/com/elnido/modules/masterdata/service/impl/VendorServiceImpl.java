package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.mapper.VendorMapper;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.Partner2BankAccountService;
import com.elnido.modules.masterdata.service.VendorService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class VendorServiceImpl extends ServiceImpl<VendorMapper, Vendor> implements VendorService {

    @Resource
    private BankAccountService bankAccountService;

    @Resource
    private Partner2BankAccountService partner2BankAccountService;

    @Resource
    private VendorMapper vendorMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createVendor(Vendor vendor) {
        Boolean saveBankAccount;
        Boolean saveRelation;
        boolean saveVendor = this.save(vendor);
        final String createdVendorId = vendor.getId();

        if (Objects.nonNull(vendor.getBankAccounts())) {
            saveBankAccount = bankAccountService.saveBatch(vendor.getBankAccounts());

            List<Partner2BankAccount> partner2BankAccountList = vendor.getBankAccounts().stream()
                    .map(bankAccount -> {
                        Partner2BankAccount partner2BankAccount = new Partner2BankAccount();
                        partner2BankAccount.setPartnerId(createdVendorId);
                        partner2BankAccount.setBankAccountId(bankAccount.getId());
                        partner2BankAccount.setPartnerType(PartnerTypeEnum.VENDOR);
                        return partner2BankAccount;
                    })
                    .collect(Collectors.toList());
            saveRelation = partner2BankAccountService.saveBatch(partner2BankAccountList);

            return saveVendor && saveBankAccount && saveRelation;
        }

        return saveVendor;
    }

    @Override
    public Vendor findVendorById(String id) {
        return vendorMapper.findVendorWithBankAccounts(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateVendorWithBankAccounts(Vendor vendor) {
        Boolean saveOrUpdatedBankAccount;
        boolean updated = this.updateById(vendor);
        if (Objects.nonNull(vendor.getBankAccounts())) {
            saveOrUpdatedBankAccount = bankAccountService.saveOrUpdateBatch(vendor.getBankAccounts());
            return updated && saveOrUpdatedBankAccount;
        }

        return updated;
    }
}
