package org.jeecg;

import com.elnido.modules.masterdata.entity.Bank;
import com.elnido.modules.masterdata.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@Slf4j
public class BankTest {

	@Resource
	private BankService bankService;

	@Test
	public void test_find_all_banks() {
		List<Bank> bankList = bankService.findAllBanks();
		Assert.assertThat(bankList, notNullValue());
		Assert.assertThat(bankList.size() > 0, is(Boolean.TRUE));

		log.info("banks: ");
		bankList.stream().forEach(bank -> {
			System.out.println(bank);
		});
	}

	@Test
	public void test_find_subbranches_by_bank_id() {
		List<Bank> subbranches = bankService.findSubbranchesByBankId("1001");
		Assert.assertThat(subbranches, notNullValue());
		Assert.assertThat(subbranches.size() > 0, is(Boolean.TRUE));

		log.info("subbranches: ");
		subbranches.stream().forEach(subbranch -> {
			System.out.println(subbranch);
		});
	}

}
