package com.project.TaskUnity.rest;

import com.project.TaskUnity.dao.UserDAOImpl;
import com.project.TaskUnity.entity.User;
import com.project.TaskUnity.model.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private UserDAOImpl userService;
    @Autowired

    public UserController(UserDAOImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> user(){
        return this.userService.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> validateUser(@RequestBody ValidateUser userDetails) {
        return this.userService.validateUser(userDetails);
    }

    @Transactional
    @PostMapping("/register")
    public User addUser(@RequestBody User theUser){
        return this.userService.save(theUser);
    }

}

