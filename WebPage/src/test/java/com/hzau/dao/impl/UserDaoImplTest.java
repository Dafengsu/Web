package com.hzau.dao.impl;

import com.hzau.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
public class UserDaoImplTest {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void finUserByUsernameAndPassword() {
        User user = userDao.finUserByUsernameAndPassword("zhangsan", "123");
        assertNotNull(user);
    }

//    @Test
//    public void addUser() {
//        User user = new User();
//        user.setName("wuli");
//        user.setGender("男");
//        user.setAddress("afa");
//        user.setQq("q1231");
//        user.setEmail("123131");
//        user.setAge(18);
//        userDao.addUser(user);
//    }




    @Test
    public void delUserById() {
        userDao.delUserById(10);
    }

    @Test
    public void findUserById() {
        User user = userDao.findUserById(1);
        assertNotNull(user);
    }

    @Test
    public void updateUser() {


    }
}
