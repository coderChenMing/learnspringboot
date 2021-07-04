package com.learnspringboot;/*
 * Project: springboot03
 * File Created at 2021-07-04 16:02:16:02
 * @Type PersonCacheTest.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 16:02
 * @version 1.0.0
 */

import com.learnspringboot.domain.Person;
import com.learnspringboot.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Springboot02Application.class})
public class PersonCacheTest {
    @Autowired
    private PersonService personService;

    @Test
    public void testSave() {
        Person person1 = new Person("贾宝玉", 19, "金陵贾府");
        personService.savePerson(person1);

    }

    @Test
    public void findById() {
        Person person = personService.findPersonById(2);
        System.out.println(person);
    }
    @Test
    public void testFindAll() {
        List<Person> list = personService.findAllPerson();
        for (Person person : list) {
            System.out.println(person);
        }

    }

}
