package com.learnspringboot.controller;

import com.learnspringboot.mapper.ItemsMapper;
import com.learnspringboot.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author coderChenMing
 * @create 2021-03-25-18:27
 * @description mybatis测试类
 */
@RestController
public class MybatisController {
    @Autowired
    private ItemsMapper itemsMapper;
    @RequestMapping("findById")
    public Items selectListByIds() {
        return itemsMapper.findById(1);
    }
    @RequestMapping("findAll")
    public List<Items> selectList() {
        return itemsMapper.findAll();
    }
}
