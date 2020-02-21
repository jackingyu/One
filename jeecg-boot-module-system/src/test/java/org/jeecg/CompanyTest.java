package org.jeecg;

import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.model.CompanyPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.CompanyService;
import com.elnido.modules.masterdata.service.Partner2BankAccountService;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyTest extends BaseTest{

	public static final String IMPORTED_COMPANY_ID = "eaa2aab69d74443ebc025ee4fd76b882";

	public static final String IMPORTED_FIRST_BANK_ACCOUNT = "8f1556b40937492bb1fbeeba086fc110";

	@Resource
	private CompanyService companyService;

	@Resource
	private BankAccountService bankAccountService;

	@Resource
	private Partner2BankAccountService partner2BankAccountService;

	@Test
	public void a_test_create_company() {
		Company mockCompany = createMockCompany("mock-company-code-1", "mock-company-name-1");
		List<BankAccount> bankAccountList = IntStream.range(1, 4).mapToObj(index -> createMockBankAccount("1001", "1001111101" + index, "mock-bank-account" + index, "mock-bank-account-name" + index))
				.collect(Collectors.toList());

		mockCompany.setBankAccounts(bankAccountList);

		boolean created = companyService.createCompany(mockCompany);
		Assert.assertThat(created, is(true));

		String companyId = mockCompany.getId();
		Assert.assertThat(companyId, notNullValue());

		mockCompany.getBankAccounts().forEach(bankAccount -> {
			Assert.assertThat(bankAccount.getId(), notNullValue());
		});

		List<Partner2BankAccount> partner2BankAccountList = partner2BankAccountService.findPartner2BankAccountRelByPartnerId(companyId);
		Assert.assertThat(partner2BankAccountList, notNullValue());
		Assert.assertThat(partner2BankAccountList.size(), is(3));

		partner2BankAccountList.forEach(partner2BankAccount -> {
			Assert.assertThat(partner2BankAccount.getPartnerType(), is(PartnerTypeEnum.COMPANY));
		});
	}

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/company/setup-company-data-h2.sql")
	public void b_test_find_paged_company() {
		CompanyPage<Company> companyPage = new CompanyPage<>(1, 10);
		CompanyPage<Company> companyPageSearchResult = companyService.findPagedCompanies(companyPage);
		Assert.assertThat(companyPageSearchResult, notNullValue());
		Assert.assertThat(companyPageSearchResult.getRecords().size(), is(6));

		log.info("companies: ");
		companyPageSearchResult.getRecords().stream().forEach(company -> {
			System.out.println(company);
		});
	}

	@Test
	public void c_test_find_paged_company_with_company_name_fuzzy_search() {
		CompanyPage<Company> companyPage = new CompanyPage<>(1, 10);
		companyPage.setCompanyName("001");
		CompanyPage<Company> companyPageSearchResult = companyService.findPagedCompanies(companyPage);
		Assert.assertThat(companyPageSearchResult, notNullValue());
		Assert.assertThat(companyPageSearchResult.getRecords().size(), is(1));

		List<Company> records = companyPageSearchResult.getRecords();
		Company searchCompany = records.get(0);
		Assert.assertThat(searchCompany.getBankAccounts(), notNullValue());
		Assert.assertThat(searchCompany.getBankAccounts().size(), is(3));

		List<BankAccount> bankAccounts = searchCompany.getBankAccounts();
		bankAccounts.forEach(bankAccount -> {
			Assert.assertThat(bankAccount.getBankName(), notNullValue());
			Assert.assertThat(bankAccount.getSubBranchName(), notNullValue());
		});

		log.info("companies: ");
		companyPageSearchResult.getRecords().stream().forEach(company -> {
			System.out.println(company);
		});
	}

	@Test
	public void d_test_find_all_company_info_by_company_id() {
		Company company = companyService.findCompanyWithBankAccountById(IMPORTED_COMPANY_ID);
		Assert.assertThat(company, notNullValue());
		Assert.assertThat(company.getBankAccounts(), notNullValue());
		Assert.assertThat(company.getBankAccounts().size(), is(3));

		List<Partner2BankAccount> partner2BankAccountList =
				partner2BankAccountService.findPartner2BankAccountRelByPartnerId(IMPORTED_COMPANY_ID);
		Assert.assertThat(partner2BankAccountList, notNullValue());
		Assert.assertThat(partner2BankAccountList.size(), is(3));

	}

	@Test
	public void e_test_remove_company_bank_account_by_bank_account_id() {
		//make sure it exist
		BankAccount bankAccount = bankAccountService.getById(IMPORTED_FIRST_BANK_ACCOUNT);

		Assert.assertThat(bankAccount, notNullValue());
		Assert.assertThat(bankAccount.getBankId(), is("1001"));
		Assert.assertThat(bankAccount.getSubBranchId(), is("10011111011"));
		Assert.assertThat(bankAccount.getBankAccount(), is("11111111111111111"));
		Assert.assertThat(bankAccount.getBankAccountName(), is("testbank001"));

		boolean removeBankAccount = bankAccountService.removeBankAccountByBankAccountIdAndPartnerType(IMPORTED_FIRST_BANK_ACCOUNT, PartnerTypeEnum.COMPANY);
		Assert.assertThat(removeBankAccount, is(true));

		Company company = companyService.findCompanyWithBankAccountById(IMPORTED_COMPANY_ID);
		Assert.assertThat(company, notNullValue());
		Assert.assertThat(company.getBankAccounts(), notNullValue());
		Assert.assertThat(company.getBankAccounts().size(), is(2));

		List<Partner2BankAccount> partner2BankAccountList =
				partner2BankAccountService.findPartner2BankAccountRelByPartnerId(IMPORTED_COMPANY_ID);
		Assert.assertThat(partner2BankAccountList, notNullValue());
		Assert.assertThat(partner2BankAccountList.size(), is(2));

	}

}
