package org.jeecg;

import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;
import com.elnido.modules.purchasecontract.data.PurchaseContractPage;
import com.elnido.modules.purchasecontract.service.PurchaseContractService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseContractTest{

	public static final String IMPORT_VENDOR_ID = "603c6b21dd484511814484d08267ae63";
	public static final String IMPORT_PROJECT_ID = "e7d501cdc0a7442b96383f1b63b97ff3";
	public static final String IMPORT_COMPANY_ID = "3e574a585c5043f6a1b4fed124f6e16b";
	public static final String IMPORT_MATERIAL_ID_1 = "6ad7e77fd7b6418db75a6d20d5da2777";
	public static final String IMPORT_MATERIAL_ID_2 = "ecddb00b47d94ad0a5b7c9282a3664f6";

	@Resource
	private PurchaseContractService purchaseContractService;


	private PurchaseContract createMockPurchaseContract(String contractCode, String contractTitle, Integer contractTypeCode,
														String vendorId, String companyId, String projectId,
														Date beginDate, Date endDate) {
		PurchaseContract purchaseContract = new PurchaseContract();
		purchaseContract.setContractCode(contractCode);
		purchaseContract.setContractTitle(contractTitle);
		purchaseContract.setContractTypeCode(contractTypeCode);
		purchaseContract.setVendorId(vendorId);
		purchaseContract.setCompanyId(companyId);
		purchaseContract.setProjectId(projectId);
		purchaseContract.setBeginDate(beginDate);
		purchaseContract.setEndDate(endDate);
		return purchaseContract;
	}

	private PurchaseContractItem createMockPurchaseContractItem(Integer itemNo, String materialId, Integer unitCode,
																Double quantity, Double unitPrice, Double taxRate,
																String acceptanceCriteria, String qualityStandard,
																Integer paymentMethodCode, String paymentTerm,
																String warranty, String warrantyAgreement) {
		PurchaseContractItem purchaseContractItem = new PurchaseContractItem();
		purchaseContractItem.setItemNo(itemNo);
		purchaseContractItem.setMaterialId(materialId);
		purchaseContractItem.setUnitCode(unitCode);
		purchaseContractItem.setQuantity(quantity);
		purchaseContractItem.setUnitPrice(unitPrice);
		purchaseContractItem.setTaxRate(taxRate);
		purchaseContractItem.setAcceptanceCriteria(acceptanceCriteria);
		purchaseContractItem.setQualityStandard(qualityStandard);
		purchaseContractItem.setPaymentMethodCode(paymentMethodCode);
		purchaseContractItem.setPaymentTerm(paymentTerm);
		purchaseContractItem.setWarranty(warranty);
		purchaseContractItem.setWarrantyAgreement(warrantyAgreement);
		return purchaseContractItem;
	}

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/purchasecontract/setup-purchasecontract-data-h2.sql")
	public void a_test_create_phrase_contract() {
		PurchaseContract purchaseContract = createMockPurchaseContract("mock-purchase-contract", "mock-purchase-contract_title",
				1, IMPORT_VENDOR_ID, IMPORT_COMPANY_ID, IMPORT_PROJECT_ID, new Date(), new Date());

		PurchaseContractItem purchaseContractItem0 = createMockPurchaseContractItem(10, IMPORT_MATERIAL_ID_1, 1,
				new Double(1), new Double(10.23), new Double(17.76),"acceptanceCriteria_1", "qualityStandard_1",
				1, "paymentTerm_1", "warranty_1", "warrantyAgreement_1");

		PurchaseContractItem purchaseContractItem1 = createMockPurchaseContractItem(20, IMPORT_MATERIAL_ID_2, 1,
				new Double(1), new Double(10.23), new Double(17.76),"acceptanceCriteria_1", "qualityStandard_1",
				1, "paymentTerm_1", "warranty_1", "warrantyAgreement_1");

		List<PurchaseContractItem> purchaseContractItemList = new ArrayList<>();
		purchaseContractItemList.add(purchaseContractItem0);
		purchaseContractItemList.add(purchaseContractItem1);

		purchaseContract.setPurchaseContractItems(purchaseContractItemList);

		boolean created = purchaseContractService.createPurchaseContract(purchaseContract);
		Assert.assertThat(created, is(true));
	}

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/purchasecontract/setup-purchasecontract-search-data-h2.sql")
	public void b_test_find_paged_purchase_contract_without_any_condition() {
		PurchaseContractPage<PurchaseContract> purchaseContractPage = new PurchaseContractPage<>(1,2);
		PurchaseContractPage<PurchaseContract> pagedPurchaseContractHeaders =
				purchaseContractService.findPagedPurchaseContractHeaders(purchaseContractPage);
		log.info("purchase contracts: ");

		pagedPurchaseContractHeaders.getRecords().forEach(purchaseContract -> {
			System.out.println(purchaseContract);
		});
	}

}
