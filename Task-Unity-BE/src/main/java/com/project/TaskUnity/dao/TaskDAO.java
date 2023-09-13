package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> findTaskByProjectId(int theId);

    Task save(Task theTask);

}
