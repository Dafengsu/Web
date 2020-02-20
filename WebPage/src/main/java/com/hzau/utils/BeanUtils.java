package com.hzau.utils;

import com.hzau.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
public class BeanUtils {
    public static User beanUserByReq(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            org.apache.commons.beanutils.BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }
}
