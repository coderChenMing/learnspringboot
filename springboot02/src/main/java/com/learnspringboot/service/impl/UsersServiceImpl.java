package com.learnspringboot.service.impl;/*
 * Project: springboot03
 * File Created at 2021-07-03 23:27:23:27
 * @Type UsersServiceImpl.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 23:27
 * @version
 */

import com.learnspringboot.domain.Users;
import com.learnspringboot.mapper.UsersMapper;
import com.learnspringboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public void addUser(Users users) {
        usersMapper.insertUser(users);
    }
}
