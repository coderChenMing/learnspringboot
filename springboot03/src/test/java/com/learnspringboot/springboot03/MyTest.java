package com.learnspringboot.springboot03;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnspringboot.Springboot03Application;
import com.learnspringboot.domain.Items;
import com.learnspringboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author coderChenMing
 * @create 2021-03-25-23:18
 * @description springBootTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot03Application.class)
public class MyTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() throws JsonProcessingException {
        List<Items> all = userRepository.findAll();
        System.out.println(all);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(all);
        System.out.println(jsonString);


    }
}
