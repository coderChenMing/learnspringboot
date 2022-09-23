package com.learn.boot.bean;

import java.io.Serializable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Project: spring-boot-first
 * File Created at 2022-09-02 19:29:19:29
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type SubmitForm.java
 * @Description
 * @date 2022/9/2 19:29
 */
@Data
public class SubmitForm implements Serializable {

    private String name;

    private Integer age;

    private MultipartFile file;
}
