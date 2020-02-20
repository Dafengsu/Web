package com.hzau.service.impl;

import com.hzau.domain.PageBean;
import com.hzau.domain.User;
import com.hzau.service.UserService;
import org.junit.Test;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
public class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void findUserByPage() {
       /* PageBean<User> pb = userService.findUserByPage(1, 5, condition);
        System.out.println(pb);*/
    }
}
