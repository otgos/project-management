package com.jrp.pma.dao;

import com.jrp.pma.dto.ProjectStage;
import com.jrp.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository <Project, Long>{
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value " +
            "FROM project " +
            "GROUP BY stage")
    public List<ProjectStage> getProjectStatus();
}
