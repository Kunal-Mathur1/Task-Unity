package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.Task;
import com.project.TaskUnity.entity.TaskStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskStatusDAOImpl implements TaskStatusDAO{

    private EntityManager entityManager;

    @Autowired
    public TaskStatusDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task> theQuery = entityManager.createQuery("from TaskStatus", Task.class);
        List<Task> taskStatusList = theQuery.getResultList();
        return taskStatusList;
    }
}
