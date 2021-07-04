package com.learn.job;/*
 * Project: springboot03
 * File Created at 2021-07-04 21:03:21:03
 * @Type FirstJob.java
 * @Desc 定义任务
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 21:03
 * @version 1.0.0
 */

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class FirstJob implements Job {
    /**
     * 任务触发时执行的方法
     */
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("FirstJob is running"+new Date());
    }
}
