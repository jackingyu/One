package org.jeecg;

import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.MaterialGroup;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialGroupService;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.vo.MaterialVO;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.demo.mock.MockController;
import org.jeecg.modules.demo.test.entity.JeecgDemo;
import org.jeecg.modules.demo.test.mapper.JeecgDemoMapper;
import org.jeecg.modules.demo.test.service.IJeecgDemoService;
import org.jeecg.modules.system.service.ISysDataLogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
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
		materialPage.setMaterialName("测试");
		MaterialPage<MaterialVO> materialVOPage = materialService.findPagedMaterials(materialPage);
		log.info(materialVOPage.getRecords().toString());
		log.info("总条数 -------------> {}", materialVOPage.getTotal());
		log.info("当前页数 -------------> {}", materialVOPage.getCurrent());
		log.info("当前每页显示数 -------------> {}", materialVOPage.getSize());
	}

	@Test
	public void test_create_material() {
		Material material = createMockMaterial("模拟测试物料001","模拟测试物料001描述", "100", 1);
		boolean created = materialService.createMaterial(material);
		Assert.assertThat(created, is(true));
	}

	@Test
	public void test_update_material() {
		Material material = createMockMaterial("模拟测试物料002","模拟测试物料002描述", "200", 1);
		boolean created = materialService.createMaterial(material);

		Assert.assertThat(created, is(true));
		material.setMaterialName("模拟测试物料002-更新");
		material.setMaterialDescription("模拟测试物料002描述-更新");
		material.setMaterialGroupCode(2);

		boolean updated = materialService.updateMaterial(material);
		Assert.assertThat(updated, is(true));
	}

}
