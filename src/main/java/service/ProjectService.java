package service;

import dao.ProjectRepository;
import model.ProjectInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author jack-gu */
@Service
public class ProjectService {

  private ProjectRepository projectRepository;

  public void setProjectRepository(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  /**
   * @param newProject input project
   * @throws Exception project existed
   */
  public void addProject(ProjectInfo newProject) throws Exception {
    if (newProject == null
        || newProject.getProjectName() == null
        || newProject.getProjectAddress() == null) {
      throw new IllegalArgumentException();
    }

    int id = newProject.getProjectId();
    ProjectInfo dbProject = projectRepository.queryByProjectId(id);
    if (dbProject != null) {
      throw new Exception("project existed");
    }

    try {
      projectRepository.save(newProject);
    } catch (Exception e) {
      throw new Exception("database failed", e);
    }
  }

  /** @param id id of the project */
  public void queryProjectById(int id) throws Exception {
    ProjectInfo dbProject = projectRepository.queryByProjectId(id);
    if (dbProject == null) {
      throw new Exception("no data found");
    }
  }

  public List<ProjectInfo> getAllProject() {
    return projectRepository.findAll();
  }
}
