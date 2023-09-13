package com.project.TaskUnity.rest;

import com.project.TaskUnity.dao.TaskStatusDAOImpl;
import com.project.TaskUnity.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskStatusController {

    private TaskStatusDAOImpl taskService;

    @Autowired
    public TaskStatusController(TaskStatusDAOImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/taskStatus")
    public List<Task> taskStatus(){
        return taskService.findAll();
    }
}
