package com.learn.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-02 16:51:16:51
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Pet.java
 * @Desc
 * @date 2022/3/2 16:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String name;
    private Double weight;

    public Pet(String name) {
        this.name = name;
    }
}
