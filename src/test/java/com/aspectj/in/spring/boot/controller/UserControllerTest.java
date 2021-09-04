package com.aspectj.in.spring.boot.controller;

import com.aspectj.in.spring.boot.AspectjInSpringBootApplicationTests;
import com.aspectj.in.spring.boot.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UserControllerTest extends AspectjInSpringBootApplicationTests {

    @Test
    void getUsers() {

        String url = "/v1/users";

        ParameterizedTypeReference<List<User>> typeReference =
                new ParameterizedTypeReference<>() {
                };

        ResponseEntity<List<User>> responseEntity =
                testRestTemplate.exchange(url, HttpMethod.GET, null, typeReference);

        HttpStatus statusCode = responseEntity.getStatusCode();

        assertThat(statusCode, is(HttpStatus.OK));

        List<User> employeeDtoList = responseEntity.getBody();

        System.out.println(employeeDtoList);

    }

 }