package com.learnspringboot.service;/*
 * Project: springboot03
 * File Created at 2021-07-04 15:41:15:41
 * @Type PersonService.java
 * @Desc
 * @author <a href="mailto: ">chenming</a>
 * @date 2021/7/4 0004 15:41
 * @version 1.0.0
 */

import com.learnspringboot.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    List<Person> findAllPerson();

    Person findPersonById(Integer id);

    Page<Person> findPersonByPage(Pageable pageable);

    void savePerson(Person person);
}
