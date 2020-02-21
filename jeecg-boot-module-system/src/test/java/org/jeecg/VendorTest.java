package org.jeecg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendorTest {

	@Resource
	private VendorService vendorService;

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/vendor/setup-vendor-data-h2.sql")
	public void a_test_find_paged_vendor() {
		IPage<Vendor> vendorPage = new Page<>(3, 2);
		IPage<Vendor> pagedVendor = vendorService.page(vendorPage);
		Assert.assertThat(pagedVendor, notNullValue());
		Assert.assertThat(pagedVendor.getRecords().size(), is(1));

		log.info("vendors: ");
		pagedVendor.getRecords().stream().forEach(vendor -> {
			System.out.println(vendor);
		});
	}
}
