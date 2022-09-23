package com.learn.boot.circle.dependency;

/**
 * Project: spring-boot-first
 * File Created at 2022-08-31 19:19:19:19
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type B.java
 * @Description
 * @date 2022/8/31 19:19
 */
public class B {
    private A a;

    public B(A a) {
        this.a = a;
    }
}
