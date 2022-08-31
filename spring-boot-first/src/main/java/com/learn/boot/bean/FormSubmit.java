package com.learn.boot.bean;

import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Project: spring-boot-first
 * File Created at 2022-08-31 15:54:15:54
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type FormSubmit.java
 * @Description
 * @date 2022/8/31 15:54
 */
@Data
public class FormSubmit {
    
    private List<MultipartFile> fileList;
    
    private List<Student> stuList;
}
