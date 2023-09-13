package com.project.TaskUnity.rest;

import com.project.TaskUnity.dao.TaskDAOImpl;
import com.project.TaskUnity.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private TaskDAOImpl taskService;

    @Autowired
    public TaskController(TaskDAOImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{projectId}")
    public List<Task> taskByProjectId(@PathVariable int projectId){
        return taskService.findTaskByProjectId(projectId);
    }

    @PostMapping("/task")
    @Transactional
    public Task addTask(@RequestBody Task theTask){
        return taskService.save(theTask);
    }
}
