package dao;

import model.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jack-gu
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectInfo, Integer> {
	
	ProjectInfo queryByProjectId(int id);
}
