package com.aspectj.in.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class AspectjInSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectjInSpringBootApplication.class, args);
    }

}
