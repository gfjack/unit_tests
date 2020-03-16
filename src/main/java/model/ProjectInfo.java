package model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

/** @author jack-gu entity for project model */
@Entity(name = "t_projectinfo")
@Data
public class ProjectInfo {
  @Id private int projectId;
  private String projectName;
  private String projectAddress;

  public ProjectInfo(int projectId, String projectName, String projectAddress) {
    this.projectId = projectId;
    this.projectName = projectName;
    this.projectAddress = projectAddress;
  }
}
