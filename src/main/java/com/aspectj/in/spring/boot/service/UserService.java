package com.aspectj.in.spring.boot.service;


import com.aspectj.in.spring.boot.dto.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
}
