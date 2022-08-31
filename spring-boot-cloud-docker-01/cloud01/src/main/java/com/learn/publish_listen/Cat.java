package com.learn.publish_listen;

import java.util.Observable;
import java.util.Observer;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:02:15:02
 * {@link}
 *  观察者：它会观察主人，只要放鱼了它就会去吃（消费）
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Cat.java
 * @Description
 * @date 2022/6/17 15:02
 */
public class Cat implements Observer {
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        String masterName = o.toString();
        // 因为该观察者接口没有泛型 所以只能强转
        if (o instanceof Master) {
            masterName = ((Master) o).name;
        }
        System.out.println(name + "吃了主人" + masterName + "放的鱼");
    }
}
