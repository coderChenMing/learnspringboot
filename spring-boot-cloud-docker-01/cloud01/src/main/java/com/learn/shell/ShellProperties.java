package com.learn.shell;

import java.io.File;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Project: learnspringboot
 * File Created at 2022-06-20 11:24:11:24
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ShellProperties.java
 * @Description
 * @date 2022/6/20 11:24
 */
@Configuration
@ConfigurationProperties(prefix = "shell")
public class ShellProperties {
    private String directory;
    private String startupFileName;
    private String restartFileName;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getStartupFileName() {
        return startupFileName;
    }

    public void setStartupFileName(String startupFileName) {
        this.startupFileName = startupFileName;
    }

    public String getRestartFileName() {
        return restartFileName;
    }

    public void setRestartFileName(String restartFileName) {
        this.restartFileName = restartFileName;
    }

    public String getFullName(String fileName) {
        return directory + File.separator + fileName;
    }
}
