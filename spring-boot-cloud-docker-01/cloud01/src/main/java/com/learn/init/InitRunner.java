package com.learn.init;

import com.learn.shell.ShellProperties;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Project: learnspringboot
 * File Created at 2022-06-20 11:26:11:26
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type InitRunner.java
 * @Description
 * @date 2022/6/20 11:26
 */
@Component
public class InitRunner implements CommandLineRunner {
    @Autowired
    private ShellProperties shellProperties;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        generateFile(shellProperties.getStartupFileName());
        generateFile(shellProperties.getRestartFileName());
    }

    private void generateFile(String fileName) throws IOException {

        String fileFullName = shellProperties.getFullName(fileName);
        File file = new File(fileFullName);
        if (file.exists()) {
            return;
        }
        // 如果文件已存在，FileWriter 会先删除再新建
        FileWriter fileWriter = new FileWriter(fileFullName);

        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String data;
        while ((data = bufferedReader.readLine()) != null) {
            fileWriter.write(data + "\n");
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        fileWriter.close();

        // 设置权限，否则会报 Permission denied
        file.setReadable(true);
        file.setWritable(true);
        file.setExecutable(true);
    }
}
