package com.aspectj.in.spring.boot.controller;

import com.aspectj.in.spring.boot.aop.aspect.auditlog.annotation.AuditAnnotation;
import com.aspectj.in.spring.boot.dto.User;
import com.aspectj.in.spring.boot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {

        List<User> userList = getUsersInternal();

        return userList;
    }

    @AuditAnnotation
    private List<User> getUsersInternal() {

        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }
}
