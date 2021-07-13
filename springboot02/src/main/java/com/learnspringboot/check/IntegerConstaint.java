package com.learnspringboot.check;/*
 * Project: springboot03
 * File Created at 2021-07-07 21:43:21:43
 * @Type IntegerConstaint.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/7 0007 21:43
 * @version 1.0.0
 */

import com.learnspringboot.check.anno.IntegerCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerConstaint implements ConstraintValidator<IntegerCheck, Integer> {
    private int[] defineValue;

    @Override
    public void initialize(IntegerCheck constraintAnnotation) {
        defineValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (null != defineValue && defineValue.length > 0) {
            for (int i : defineValue) {
                if (i == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
