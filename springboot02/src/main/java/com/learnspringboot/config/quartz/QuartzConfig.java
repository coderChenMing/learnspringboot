package com.learnspringboot.config.quartz;/*
 * Project: springboot03
 * File Created at 2021-07-04 21:31:21:31
 * @Type QuartzConfig.java
 * @Desc
 * @author <a href="mailto: ">chenming</a>
 * @date 2021/7/4 0004 21:31
 * @version 1.0.0
 */

import com.learnspringboot.quartz.FirstJob;
import com.learnspringboot.quartz.MyAdaptableJobFactory;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

//@Configuration
public class QuartzConfig {
    /**
     * 1.创建Job
     */
    //@Bean
    public JobDetailFactoryBean getJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        // FirstJob交给AdaptableJobFactory通过反射的方式实例化，没有交给spring ioc容器管理
        factoryBean.setJobClass(FirstJob.class);
        return factoryBean;
    }

    /**
     * 2.创建trigger
     */
   /* @Bean
    public SimpleTriggerFactoryBean getTrigger(JobDetailFactoryBean factoryBean) {
        SimpleTriggerFactoryBean triggerFactoryBean = new SimpleTriggerFactoryBean();
        // 关联Job对象
        triggerFactoryBean.setJobDetail(factoryBean.getObject());
        // 设置触发时间:单位毫秒
        triggerFactoryBean.setRepeatInterval(2000l);
        // 设置重复次数
        triggerFactoryBean.setRepeatCount(4);
        return triggerFactoryBean;
    }*/

    /**
     * 3.创建scheduler
     */
   /* @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(SimpleTriggerFactoryBean triggerFactoryBean) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(triggerFactoryBean.getObject());
        return factoryBean;
    }*/

    /**
     * 2.创建cron trigger
     */
    //@Bean
    public CronTriggerFactoryBean getCronTrigger(JobDetailFactoryBean factoryBean) {
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(factoryBean.getObject());
        factory.setCronExpression("5,45 * * * * ?");
        return factory;
    }

    /**
     * 3.创建cron scheduler
     */
    //@Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(CronTriggerFactoryBean triggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(triggerFactoryBean.getObject());
        factoryBean.setJobFactory(myAdaptableJobFactory);
        return factoryBean;
    }
}
