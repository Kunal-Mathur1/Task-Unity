package com.project.TaskUnity.rest;

import com.project.TaskUnity.dao.ProjectDAOImpl;
import com.project.TaskUnity.entity.Project;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectDAOImpl projectService;
    public ProjectController(ProjectDAOImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project/{userId}")
    public List<Project> project(@PathVariable int userId){
        return projectService.findProjectByuserId(userId);
    }

    @PostMapping("/project")
    @Transactional
    public Project addProject(@RequestBody Project theProject){
        System.out.println(theProject);
        theProject.setId(0);
        Project dbEmployee = projectService.save(theProject);
        return dbEmployee;
    }

}
