package com.learnspringboot.dao;/*
 * Project: springboot03
 * File Created at 2021-07-04 15:44:15:44
 * @Type PersonRepository.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 15:44
 * @version 1.0.0
 */

import com.learnspringboot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {

}
