package com.learnspringboot.service.impl;/*
 * Project: springboot03
 * File Created at 2021-07-04 15:43:15:43
 * @Type PersonServiceImpl.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 15:43
 * @version 1.0.0
 */

import com.learnspringboot.dao.PersonRepository;
import com.learnspringboot.domain.Person;
import com.learnspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    @Cacheable(value="person")
    public Person findPersonById(Integer id) {
        return personRepository.findById(id).get();//springboot2.x之后不再支持findOne()
    }

    @Override
    @Cacheable(value = "person",key = "#pageable.pageSize")
    public Page<Person> findPersonByPage(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    @CacheEvict(value = "person",allEntries=true)
    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
