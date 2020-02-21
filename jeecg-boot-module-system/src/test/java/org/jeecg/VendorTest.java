package org.jeecg;

import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.model.VendorPage;
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

	public static final String SEARCH_VENDOR_TEST_ID = "a0b70f81423141cd8bb2d57b2e6bbab1";

	@Resource
	private VendorService vendorService;

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/vendor/setup-vendor-data-h2.sql")
	public void b_test_find_paged_vendor() {
		VendorPage<Vendor> vendorPage = new VendorPage<>(3, 2);
		VendorPage<Vendor> pagedVendor = vendorService.findPagedVendor(vendorPage);
		Assert.assertThat(pagedVendor, notNullValue());
		Assert.assertThat(pagedVendor.getRecords().size(), is(1));

		log.info("vendors: ");
		pagedVendor.getRecords().stream().forEach(vendor -> {
			System.out.println(vendor);
		});
	}

	@Test
	public void c_test_find_paged_vendor_by_vendor_group_id() {
		VendorPage<Vendor> vendorPage = new VendorPage<>(1, 10);
		vendorPage.setVendorGroupId(SEARCH_VENDOR_TEST_ID);
		VendorPage<Vendor> pagedVendor = vendorService.findPagedVendor(vendorPage);
		Assert.assertThat(pagedVendor, notNullValue());
		Assert.assertThat(pagedVendor.getRecords().size(), is(3));

		log.info("vendors: ");
		pagedVendor.getRecords().stream().forEach(vendor -> {
			System.out.println(vendor);
		});
	}

	@Test
	public void d_test_find_paged_vendor_by_vendor_name() {
		VendorPage<Vendor> vendorPage = new VendorPage<>(1, 10);
		vendorPage.setVendorName("005");
		VendorPage<Vendor> pagedVendor = vendorService.findPagedVendor(vendorPage);
		Assert.assertThat(pagedVendor, notNullValue());
		Assert.assertThat(pagedVendor.getRecords().size(), is(1));

		log.info("vendors: ");
		pagedVendor.getRecords().stream().forEach(vendor -> {
			System.out.println(vendor);
		});
	}
}
