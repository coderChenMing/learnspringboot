package com.learnspringboot.service;/*
 * Project: springboot03
 * File Created at 2021-07-03 23:26:23:26
 * @Type UsersService.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 23:26
 * @version
 */

import com.learnspringboot.domain.Users;

import java.util.List;

public interface UsersService {
    void addUser(Users users);

    List<Users> findUserAll();

    Users findUsersById(Integer id);

    void updateUser(Users users);

    void deleteUsersById(Integer id);
}
