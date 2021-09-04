package com.aspectj.in.spring.boot.aop.aspect.auditlog.interceptor;

import com.aspectj.in.spring.boot.service.LoggingService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Aspect
public class LoggingInterceptorAspect {


    private LoggingService loggingService;

    @Autowired
    public LoggingInterceptorAspect(LoggingService loggingService) {
        this.loggingService = loggingService;
    }


    @Pointcut("execution(private * *(..))")
    public void privateMethod() {
    }

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Pointcut("@annotation(com.aspectj.in.spring.boot.aop.aspect.auditlog.annotation.AuditAnnotation)")
    public void annotatedMethodCustom() {
    }


    @Before("annotatedMethodCustom() && privateMethod() && publicMethod()")
    public void addCommandDetailsToMessage() throws Throwable {

        ZonedDateTime dateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String message = String.format("User controller getUsers method called at %s", dateTime);

        System.out.println("+++++++++++++++++++++++++");
        loggingService.log(message);
    }

}