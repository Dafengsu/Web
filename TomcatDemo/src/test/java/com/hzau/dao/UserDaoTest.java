package com.hzau.dao;

import com.hzau.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: su
 * @date: 2020/2/18
 */
public class UserDaoTest {

    @Test
    public void login() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("1234");
        UserDao dao = new UserDao();
        User login = dao.login(user);
        assertNull(login);
        user.setPassword("123");
        login = dao.login(user);
        assertNotNull(login);
    }
}
