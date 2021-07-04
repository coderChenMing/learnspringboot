package com.learnspringboot;/*
 * Project: springboot03
 * File Created at 2021-07-04 17:53:17:53
 * @Type UsersRedisTest.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 17:53
 * @version 1.0.0
 */

import com.learnspringboot.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Springboot02Application.class})
public class UsersRedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void testRedisSet() {
        redisTemplate.opsForValue().set("name","张三");
    }
    @Test
    public void testRedisGet() {
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
    @Test
    public void TestFindById() {

    }
}
