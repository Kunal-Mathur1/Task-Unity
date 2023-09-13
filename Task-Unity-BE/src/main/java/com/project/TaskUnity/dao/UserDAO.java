package com.project.TaskUnity.dao;

import com.project.TaskUnity.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

}
