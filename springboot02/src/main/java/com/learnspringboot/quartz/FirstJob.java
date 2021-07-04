package com.learnspringboot.quartz;/*
 * Project: springboot03
 * File Created at 2021-07-04 21:28:21:28
 * @Type FirstJob.java
 * @Desc  定义job类
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 21:28
 * @version 1.0.0
 */

import com.learnspringboot.domain.Users;
import com.learnspringboot.service.UsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class FirstJob implements Job {
    @Autowired
    private UsersService usersService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Users> users = usersService.findUserAll();
        System.out.println(""+new Date()+" "+users);
    }
}
