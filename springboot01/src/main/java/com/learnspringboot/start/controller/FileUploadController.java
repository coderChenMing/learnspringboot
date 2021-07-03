package com.learnspringboot.start.controller;/*
 * Project: springboot03
 * File Created at 2021-07-03 15:14:15:14
 * @Type FileUploadController.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 15:14
 * @version
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {
    /*处理文件上传*/
    @RequestMapping("/upload")
    public Map<String, Object> uploadFile(MultipartFile fileName) throws IOException {
        // 打印文件名
        System.out.println(fileName.getOriginalFilename());
        // 对上传文件进行保存
        fileName.transferTo(new File("d:/" + fileName.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "success");
        return map;
    }

}
