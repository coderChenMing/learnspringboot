package com.learnspringboot.check.anno;/*
 * Project: springboot03
 * File Created at 2021-07-07 21:33:21:33
 * @Type IntegerCheck.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/7 0007 21:33
 * @version 1.0.0
 */

import com.learnspringboot.check.IntegerConstaint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author charmFlightChen
 */
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= IntegerConstaint.class)
public @interface IntegerCheck{
    int[] value() default { };

    String message() default "请输入正确参数";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}