package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Customer;

/**
 * @author baogang
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 新建客户
     * @param customer
     * @return
     */
    boolean createCustomer(Customer customer);
}
