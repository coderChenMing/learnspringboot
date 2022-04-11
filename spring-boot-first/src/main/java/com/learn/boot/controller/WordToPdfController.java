package com.learn.boot.controller;

import com.learn.boot.util.WordUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: spring-boot-first
 * File Created at 2022-04-11 17:56:17:56
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type WordToPdfController.java
 * @Description
 * @date 2022/4/11 17:56
 */
@RestController
public class WordToPdfController {

    @GetMapping("/word")
    public String makeWordToPdf() {
        WordUtil.wordToPDF("e:\\test\\word\\1.docx", "e:\\test\\pdf\\" + "1.pdf");//转pdf
        WordUtil.wordToPDF("e:\\test\\word\\2.docx", "e:\\test\\pdf\\" + "2.pdf");//转pdf
        return "success";
    }
}
