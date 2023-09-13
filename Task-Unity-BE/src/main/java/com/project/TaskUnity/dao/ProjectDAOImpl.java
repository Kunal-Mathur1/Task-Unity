package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    private EntityManager entityManager;

    @Autowired
    public ProjectDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Project> findProjectByuserId(int theId) {
        TypedQuery<Project> theQuery = entityManager.createQuery("from Project where createdBy = :userId", Project.class);
        theQuery.setParameter("userId",theId);
        List<Project> projects = theQuery.getResultList();
        return projects;
    }

    @Override
    public Project save(Project theProject) {
        Project dbProject = entityManager.merge(theProject);
        return dbProject;
    }
}
