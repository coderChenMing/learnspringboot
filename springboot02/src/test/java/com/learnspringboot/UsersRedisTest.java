package com.learnspringboot;/*
 * Project: springboot03
 * File Created at 2021-07-04 17:53:17:53
 * @Type UsersRedisTest.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 17:53
 * @version 1.0.0
 */

import com.learnspringboot.domain.Users;
import com.learnspringboot.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Springboot02Application.class})
public class UsersRedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private UsersService usersService;

    @Test
    public void testRedisSet() {
        redisTemplate.opsForValue().set("name","张三");
    }
    @Test
    public void testRedisSetUser() {
        Users user = usersService.findUsersById(2);
        // User对象不是字符串，需要重新设置序列化器
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("user",user);
    }
    @Test
    public void testRedisGetUser() {
        // User对象不是字符串，需要重新设置序列化器
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Object o = redisTemplate.opsForValue().get("user");
        System.out.println(o);
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
