package com.application.controllers;

import com.application.models.User;
import com.application.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Milos on 2/5/2018.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<User> list(){
        return userService.list();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }


}
