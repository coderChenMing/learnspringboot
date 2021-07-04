package com.learnspringboot.mapper;/*
 * Project: springboot03
 * File Created at 2021-07-03 23:18:23:18
 * @Type UsersMapper.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 23:18
 * @version
 */

import com.learnspringboot.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    void insertUser(Users users);
    List<Users> selectUsersAll();
    Users selectUsersById(Integer id);
    void updateUser(Users users);
    void deleteUserById(Integer id);
}
