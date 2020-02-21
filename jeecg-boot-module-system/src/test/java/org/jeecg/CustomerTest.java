package org.jeecg;

import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.entity.Customer;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.service.CompanyService;
import com.elnido.modules.masterdata.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {

    @Resource
    private CustomerService customerService;

    private Customer createMockCustomer(String customerCode, String customerName, Integer customerGroupCode) {
        Customer customer = new Customer();
        customer.setCustomerCode(customerCode);
        customer.setCustomerName(customerName);
        customer.setCustomerGroupCode(1);
        return customer;
    }

    @Test
    public void a_test_create_customer() {
        Customer customer = createMockCustomer("test_customer_code", "test_customer_name", 1);
        boolean createdCustomer = customerService.createCustomer(customer);
        Assert.assertThat(createdCustomer, is(true));
        Assert.assertThat(customer.getId(), notNullValue());
    }
}
