package com.hzau.utils;

import com.hzau.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: su
 * @date: 2020/2/18
 */
public class BeanUtilsTest {
    @Test
    public void test() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "hehe", "男");
            System.out.println(user);
            String hehe = BeanUtils.getProperty(user, "hehe");
            System.out.println(hehe);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
