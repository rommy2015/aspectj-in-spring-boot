package com.aspectj.in.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AspectjInSpringBootApplicationTests {

   @Autowired
   protected TestRestTemplate testRestTemplate;

}
