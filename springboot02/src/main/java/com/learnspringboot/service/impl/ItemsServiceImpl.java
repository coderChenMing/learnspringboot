package com.learnspringboot.service.impl;

import com.learnspringboot.mapper.ItemsMapper;
import com.learnspringboot.domain.Items;
import com.learnspringboot.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author coderChenMing
 * @create 2021-03-22-11:55
 * @description service实现类
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public Items findById(Integer id) {

        return itemsMapper.findById(id);
    }
}
