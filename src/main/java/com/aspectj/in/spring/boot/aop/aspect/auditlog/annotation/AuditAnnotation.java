package com.aspectj.in.spring.boot.aop.aspect.auditlog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface AuditAnnotation {

  public String value() default "";;
}
