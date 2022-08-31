package com.learn.publish_listen;

import org.springframework.beans.factory.InitializingBean;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:01:15:01
 * {@link}
 * 创建master的代理，把它放进容器内，而非Master本身
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MasterBean.java
 * @Description
 * @date 2022/6/17 15:01
 */
public class MasterBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        Master.getMaster().giveFish();
    }
}
