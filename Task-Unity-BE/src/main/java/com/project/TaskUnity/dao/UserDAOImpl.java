package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.User;
import com.project.TaskUnity.model.ValidateUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
        List<User> userList = theQuery.getResultList();
        return userList;
    }

    public ResponseEntity<Map<String, Object>> validateUser(ValidateUser userDetails){
        Map<String, Object> response = new HashMap<>();
        TypedQuery<User> theQuery = entityManager.createQuery("from User where email=:userEmail AND password=:userPaassword", User.class);
        theQuery.setParameter("userEmail", userDetails.email);
        theQuery.setParameter("userPaassword", userDetails.password);

        try {
            User user = theQuery.getSingleResult();

            if (user == null) {
                response.put("message", "Invalid email or password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // Populate response data for a successful result if user is found
            response.put("userId", user.id);
            response.put("useremail", user.email);
            response.put("userName", user.firstName + " " +  user.lastName);

            // Log the response before returning it
            System.out.println("Success response: " + response);
            return ResponseEntity.ok(response);
        } catch (NoResultException e) {
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @Override
    public User findById(int theId) {
        return null;
    }

    @Override
    public User save(User theUser) {
        User newUser = entityManager.merge(theUser);
        return newUser;
    }


}
