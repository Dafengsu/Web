package com.hzau.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzau.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
public class JacksonTest {
    @Test
    public void test1() throws IOException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
        mapper.writeValue(new File("src/test/resources/a.txt"), person);
    }

    @Test
    public void test2() throws IOException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
//        mapper.writeValue(new File("src/test/resources/a.txt"), person);
    }

    @Test
    public void test3() throws IOException {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Person person = new Person();
            person.setName("张三");
            person.setAge(23);
            person.setGender("男");
            person.setBirthday(new Date());
            list.add(person);
        }


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Test
    public void test4() throws JsonProcessingException {
        String json = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthday\":\"2020-02-22\"}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
