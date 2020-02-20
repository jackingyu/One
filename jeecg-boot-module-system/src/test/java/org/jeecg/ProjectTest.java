package org.jeecg;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.model.ProjectPage;
import com.elnido.modules.masterdata.model.VendorPage;
import com.elnido.modules.masterdata.service.CompanyService;
import com.elnido.modules.masterdata.service.ProjectService;
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
public class ProjectTest extends BaseTest{

	@Resource
	private ProjectService projectService;

	@Resource
	private CompanyService companyService;

	private Project createMockProject(String companyId, String name, String comments) {
		Project project = new Project();
		project.setCompanyId(companyId);
		project.setName(name);
		project.setComments(comments);
		return project;
	}

	@Test
	public void a_test_create_project() {
		Company company = createMockCompany("test_company_for_project", "test_company_for_project_name");
		boolean createCompany = companyService.createCompany(company);
		Assert.assertThat(createCompany, is(true));

		String companyId = company.getId();

		Project project = createMockProject(companyId, "test_project", "test_project_comment");
		boolean createdProject = projectService.createProject(project);
		Assert.assertThat(createdProject, is(true));
		Assert.assertThat(project.getId(), notNullValue());
		Project queriedProject = projectService.findAssociatedProject(project.getId());
		Company queriedAssociateCompany = queriedProject.getCompany();
		Assert.assertThat(queriedAssociateCompany, notNullValue());
		Assert.assertThat(queriedAssociateCompany.getId(), is(companyId));
		Assert.assertThat(queriedAssociateCompany.getCompanyName(), is("test_company_for_project_name"));
	}

	@Test
	@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:h2/project/setup-project-data-h2.sql")
	public void b_test_find_paged_projects() {
		ProjectPage<Project> projectPage = new ProjectPage<>(1,2);
		LambdaQueryWrapper<Project> lambdaQueryWrapper = Wrappers.<Project>lambdaQuery().like(Project::getName, "001");
		IPage<Project> projectIPage = projectService.page(projectPage, lambdaQueryWrapper);
		Assert.assertThat(projectIPage, notNullValue());
		Assert.assertThat(projectIPage.getRecords(), notNullValue());
		Assert.assertThat(projectIPage.getRecords().size(), is(1));
	}

}
