package com.learnspringboot.quartz;/*
 * Project: springboot03
 * File Created at 2021-07-04 22:06:22:06
 * @Type MyAdaptableJobFactory.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 22:06
 * @version 1.0.0
 */

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {
    @Autowired
    private AutowireCapableBeanFactory factory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        // 交给Ioc容器管理Obj对象，并完成注入
        factory.autowireBean(obj);
        return obj;
    }
}
