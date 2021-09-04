package com.aspectj.in.spring.boot.service.impl;

import com.aspectj.in.spring.boot.dto.User;
import com.aspectj.in.spring.boot.service.UserService;
import com.aspectj.in.spring.boot.service.cache.config.CacheManagerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class DefaultUserService implements UserService {

    private final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

    @Override
    public List<User> getAllUsers() {

        List<User> mockUsers = getMockUsers();

        return mockUsers;
    }


    @SuppressWarnings({"SpringCacheableComponentsInspection", "ImplicitSubclassInspection"})
    @Cacheable(CacheManagerConfig.USER_CACHE)
    private List<User> getMockUsers() {

        System.out.println("*****************************");
        logger.info(" DefaultUserService : (mock users), " +
                " list Users !");
        System.out.println("*****************************");

        return IntStream.range(0, 1000)
                .mapToObj(this::generateUserData)
                .collect(Collectors.toList());
    }

    private User generateUserData(long id) {

        String firstName = UUID.randomUUID().toString();
        String lastName = UUID.randomUUID().toString();

        return new User(id, firstName, lastName);
    }
}