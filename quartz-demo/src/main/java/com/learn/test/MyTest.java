package com.learn.test;/*
 * Project: springboot03
 * File Created at 2021-07-04 21:05:21:05
 * @Type MyTest.java
 * @Desc quartz测试类
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 21:05
 * @version 1.0.0
 */

import com.learn.job.FirstJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyTest {
    public static void main(String[] args) throws SchedulerException {
       //simpleScheduled();
       cronScheduled();
    }

    public static void simpleScheduled() throws SchedulerException {
        // 1.创建job对象
        JobDetail job = JobBuilder.newJob(FirstJob.class).build();
        // 2.创建trigger触发器
        // 2.1简单的 cron trigger：通过quartz提供的方法完成简单重复的工作
        // SimpleScheduleBuilder.repeatSecondlyForever():每秒执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();
        //3.创建scheduled调度
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
    public static void cronScheduled() throws SchedulerException {
        // 1.创建job对象
        JobDetail job = JobBuilder.newJob(FirstJob.class).build();
        // 2.创建trigger触发器
        // 2.2简单的 cron trigger：通过quartz提供的方法完成简单重复的工作
        // CronScheduleBuilder.cronSchedule():每秒执行一次
        // "5/10 * * * * ?" :每分钟的第5,15...55执行
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("5/10 * * * * ?")).build();
        //3.创建scheduled调度
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

}
