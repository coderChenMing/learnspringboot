package com.learnspringboot;

import com.learnspringboot.mapper.ItemsMapper;
import com.learnspringboot.domain.Items;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author coderChenMing
 * @create 2021-03-25-22:22
 * @description springboot测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= Springboot02Application.class)
public class MyTest {

    @Autowired
    private ItemsMapper itemsMapper;

    @Test
    public void testFindAll() {
        List<Items> all = itemsMapper.findAll();
        System.out.println(all);
    }

}
