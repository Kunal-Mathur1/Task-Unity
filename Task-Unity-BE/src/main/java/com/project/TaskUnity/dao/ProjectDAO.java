package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> findProjectByuserId(int id);

    Project save(Project theProject);
}
