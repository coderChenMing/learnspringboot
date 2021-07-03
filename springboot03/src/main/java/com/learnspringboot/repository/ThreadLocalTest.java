package com.learnspringboot.repository;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author coderChenMing
 * @create 2021-03-28-21:58
 * @description threadLocal 测试类
 */
public class ThreadLocalTest {
    private static final ThreadLocal currentUser = ThreadLocal.withInitial(() -> null);

    @GetMapping("wrong")
    public Map wrong(@RequestParam("userId") Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息ThreadLocal
        currentUser.set(userId);
        // 设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after = Thread.currentThread().getName() + ":" + currentUser.get();
        //汇总输出两次查询结果
        Map result = new HashMap();
        result.put("before", before);
        result.put("after", after);
        return result;
    }

    @Test
    public void test() {
        final ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("帅得一匹");
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println( "张三帅么 =" + threadLocal.get());
            }
        };
        t.start();
    }
}
