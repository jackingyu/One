package org.jeecg;

import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.enums.MaterialTypeEnum;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialService;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.modules.system.service.ISysDictService;
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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaterialTest {

	@Resource
	private ISysDictService iSysDictService;

	@Resource
	private MaterialService materialService;

	private Material createMockMaterial(String materialName, String materialDescription, String materialCode, Integer materialGroupCode, MaterialTypeEnum oneTimeFlag) {
		Material material = new Material();
		material.setMaterialName(materialName);
		material.setMaterialCode(materialCode);
		material.setMaterialGroupCode(materialGroupCode);
		material.setMaterialDescription(materialDescription);
//		material.setOneTimeFlag(oneTimeFlag);
		return material;
	}

	@Test
	public void a_test_find_all_material_groups() {
		List<DictModel> materialGroups = iSysDictService.queryDictItemsByCode("material_group");
		log.info("material groups: ");
		materialGroups.forEach(materialGroup -> {
			System.out.println(materialGroup);
		});
	}

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/material/setup-material-data-h2.sql")
	public void b_test_paged_materials() {
		MaterialPage<Material> materialPage = new MaterialPage<>(1, 10);
		materialPage.setMaterialGroupCode(1);
		materialPage.setMaterialName("00");
		MaterialPage<Material> searchedMaterialPage = materialService.findPagedMaterials(materialPage);
		log.info(materialPage.getRecords().toString());
		log.info("Total -------------> {}", searchedMaterialPage.getTotal());
		log.info("Current -------------> {}", searchedMaterialPage.getCurrent());
		log.info("Size -------------> {}", searchedMaterialPage.getSize());

		Assert.assertThat(searchedMaterialPage.getTotal(), is(4L));
		List<Material> records = searchedMaterialPage.getRecords();
		records.forEach(record -> {
			Assert.assertThat(record.getOneTimeFlag(), is(MaterialTypeEnum.ONE_TIME));
		});
	}

	@Test
	public void c_test_create_material() {
		Material material = createMockMaterial("Mock-Material-001","Mock-Material-001-Description", "100", 1, MaterialTypeEnum.ONE_TIME);
		boolean created = materialService.createMaterial(material);
		Assert.assertThat(created, is(true));

		String createdId = material.getId();
		Material queriedMaterial = materialService.getById(createdId);
		Assert.assertThat(queriedMaterial.getOneTimeFlag(), is(MaterialTypeEnum.ONE_TIME));
	}

	@Test
	public void d_test_update_material() {
		Material material = createMockMaterial("Mock-Material-002","Mock-Material-002-Description", "200", 1, MaterialTypeEnum.ONE_TIME);
		boolean created = materialService.createMaterial(material);

		Assert.assertThat(created, is(true));
		material.setMaterialName("Mock-Material-002-Update");
		material.setMaterialDescription("Mock-Material-002-Description-Update");
		material.setMaterialGroupCode(2);
//		material.setOneTimeFlag(MaterialTypeEnum.MULTIPLE_TIME);

		boolean updated = materialService.updateMaterial(material);
		Assert.assertThat(updated, is(true));
	}

}
