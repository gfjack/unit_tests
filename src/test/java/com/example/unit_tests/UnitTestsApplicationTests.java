package com.example.unit_tests;

import dao.ProjectRepository;
import model.ProjectInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.ProjectService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class UnitTestsApplicationTests {

	@Test
	void contextLoads() {
	}

	@org.junit.Test(expected = IllegalArgumentException.class)
	public void testNullProject() throws Exception {
		ProjectService service = new ProjectService();
		ProjectRepository repo = mock(ProjectRepository.class);
		service.setProjectRepository(repo);

		service.addProject(null);
	}

	@org.junit.Test(expected = Exception.class)
	public void testNullAddExistedProject() throws Exception {
		ProjectService service = new ProjectService();
		ProjectRepository repo = mock(ProjectRepository.class);
		service.setProjectRepository(repo);

		repo.save(new ProjectInfo(2, "testProject", "china"));
		ProjectInfo targetProject = new ProjectInfo(2, "testProject", "china");
		when(repo.queryByProjectId(2)).thenReturn(targetProject);
	}

	@org.junit.Test
	public void testGetUser() {
		ProjectService service = new ProjectService();
		ProjectRepository repo = mock(ProjectRepository.class);
		service.setProjectRepository(repo);
		repo.save(new ProjectInfo(1, "testProject", "china"));
		when(repo.findAll())
				.thenReturn(
						Stream.of(new ProjectInfo(1, "testProject", "china")).collect(Collectors.toList()));
		Assert.assertEquals(1, service.getAllProject().size());
	}

}
