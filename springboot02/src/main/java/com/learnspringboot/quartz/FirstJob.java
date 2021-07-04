package com.learnspringboot.quartz;/*
 * Project: springboot03
 * File Created at 2021-07-04 21:28:21:28
 * @Type FirstJob.java
 * @Desc  定义job类
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 21:28
 * @version 1.0.0
 */

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class FirstJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("First Job"+new Date());
    }
}
