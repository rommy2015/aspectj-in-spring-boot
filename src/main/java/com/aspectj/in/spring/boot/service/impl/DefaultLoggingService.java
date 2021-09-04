package com.aspectj.in.spring.boot.service.impl;

import com.aspectj.in.spring.boot.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A dummy implementation of logging service,
 * just to inject it in
 * {@link com.aspectj.in.spring.boot.aop.aspect.auditlog.interceptor.LoggingInterceptorAspect}
 * that's managed by AspectJ
 */
@Service
public class DefaultLoggingService implements LoggingService {

    private static final Logger logger = LoggerFactory.getLogger("sample-spring-aspectj");

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
