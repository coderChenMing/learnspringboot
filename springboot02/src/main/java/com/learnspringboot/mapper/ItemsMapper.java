package com.learnspringboot.mapper;


import com.learnspringboot.domain.Items;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author coderChenMing
 * @create 2021-03-22-11:14
 * @description dao层
 */
@Mapper
public interface ItemsMapper {

     Items findById(Integer id);

     List<Items> findAll();

}
