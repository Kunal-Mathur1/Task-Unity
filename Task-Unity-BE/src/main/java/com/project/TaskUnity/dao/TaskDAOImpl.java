package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.Project;
import com.project.TaskUnity.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO{

    private EntityManager entityManager;

    @Autowired
    public TaskDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Task> findTaskByProjectId(int theId) {
        TypedQuery<Task> theQuery = entityManager.createQuery("from Task where projectId = :projectId", Task.class);
        theQuery.setParameter("projectId",theId);
        List<Task> tasks = theQuery.getResultList();
        return tasks;
    }

    @Override
    public Task save(Task theTask) {
        Task dbTask = entityManager.merge(theTask);
        return dbTask;
    }
}
