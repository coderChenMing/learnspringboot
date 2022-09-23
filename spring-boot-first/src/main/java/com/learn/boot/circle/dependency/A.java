package com.learn.boot.circle.dependency;

/**
 * Project: spring-boot-first
 * File Created at 2022-08-31 19:18:19:18
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type A.java
 * @Description
 * @date 2022/8/31 19:18
 */
public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }
}

