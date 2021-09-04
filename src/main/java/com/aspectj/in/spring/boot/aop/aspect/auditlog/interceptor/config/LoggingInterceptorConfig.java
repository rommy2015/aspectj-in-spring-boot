package com.aspectj.in.spring.boot.aop.aspect.auditlog.interceptor.config;

import com.aspectj.in.spring.boot.aop.aspect.auditlog.interceptor.LoggingInterceptorAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class LoggingInterceptorConfig {

    @Bean
    public LoggingInterceptorAspect getAutowireCapableLoggingInterceptor() {

        return Aspects.aspectOf(LoggingInterceptorAspect.class);
    }
}
