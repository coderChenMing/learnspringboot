package com.learnspringboot.service;


import com.learnspringboot.domain.Items;

/**
 * @author coderChenMing
 * @create 2021-03-22-11:54
 * @description service接口
 */
public interface ItemsService {
    Items findById(Integer id);
}
