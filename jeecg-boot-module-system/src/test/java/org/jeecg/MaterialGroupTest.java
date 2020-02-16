package org.jeecg;

import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.MaterialGroup;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialGroupService;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.vo.MaterialVO;
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
public class MaterialGroupTest {

	@Resource
	private MaterialGroupService materialGroupService;

	@Resource
	private MaterialService materialService;

	private Material createMockMaterial(String materialName, String materialDescription, String materialCode, Integer materialGroupCode ) {
		Material material = new Material();
		material.setMaterialName(materialName);
		material.setMaterialCode(materialCode);
		material.setMaterialGroupCode(materialGroupCode);
		material.setMaterialDescription(materialDescription);
		return material;
	}

	@Test
	public void test_find_all_material_groups() {
		List<MaterialGroup> materialGroupList = materialGroupService.findAllMaterialGroups();
		Assert.assertThat(materialGroupList, notNullValue());
		Assert.assertThat(materialGroupList.size() > 0, is(Boolean.TRUE));

		log.info("material groups: ");
		materialGroupList.stream().forEach(materialGroup -> {
			System.out.println(materialGroup);
		});
	}

	@Test
	public void test_paged_materials() {
		MaterialPage<MaterialVO> materialPage = new MaterialPage<>(1, 2);
		materialPage.setMaterialGroupCode(1);
		materialPage.setMaterialName("Test");
		MaterialPage<MaterialVO> materialVOPage = materialService.findPagedMaterials(materialPage);
		log.info(materialVOPage.getRecords().toString());
		log.info("Total -------------> {}", materialVOPage.getTotal());
		log.info("Current -------------> {}", materialVOPage.getCurrent());
		log.info("Size -------------> {}", materialVOPage.getSize());
	}

	@Test
	public void test_create_material() {
		Material material = createMockMaterial("Mock-Material-001","Mock-Material-001-Description", "100", 1);
		boolean created = materialService.createMaterial(material);
		Assert.assertThat(created, is(true));
	}

	@Test
	public void test_update_material() {
		Material material = createMockMaterial("Mock-Material-002","Mock-Material-002-Description", "200", 1);
		boolean created = materialService.createMaterial(material);

		Assert.assertThat(created, is(true));
		material.setMaterialName("Mock-Material-002-Update");
		material.setMaterialDescription("Mock-Material-002-Description-Update");
		material.setMaterialGroupCode(2);

		boolean updated = materialService.updateMaterial(material);
		Assert.assertThat(updated, is(true));
	}

}
