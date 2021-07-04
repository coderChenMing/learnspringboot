package com.learnspringboot.scheduled;/*
 * Project: springboot03
 * File Created at 2021-07-04 20:27:20:27
 * @Type ScheduledDemo.java
 * @Desc spring3.0出现的定时scheduled
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 20:27
 * @version 1.0.0
 */

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledDemo {

    /**
     * 定时执行方法
     * cron:执行时间表达式
     * cron有6位，7位表示法，建议6位
     * 秒 分 时 日 月 周 (年):*表示任意 ？无意义，占位符 -:表示范围 ,:表示指定的几个值 m/n:从m开始，间隔n执行一次
     * 3,8 * * * * ?:一分钟打印两次
     * 3-8 * * * * ?:一分钟打印6次
     * 2/10 * * * * ?:每分钟的2s,12s,22s...52 执行
     * 秒：0-59
     * 分：0-59
     * 时：0-23
     * 日：1-31
     * 月：1-12
     * 周：1-7
     * 年：。。。
     * 其中日和月要联合起来定义范围的合理性
     * 设置周时也要和日月时也要观察范围的合理性
     *
     */
    //@Scheduled(cron = "2/10 * * * * ?")
    public void executeMethod() {
        System.out.println("定时器出发了"+new Date());
    }
}
