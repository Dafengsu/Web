package com.hzau.service;

import com.hzau.domain.PageBean;
import com.hzau.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author su
 * @description 用户管理接口
 * @date 2020/2/20
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    public User login(User user);


    public void addUser(User user);

    public void delUserById(Integer id);

    public User findUserById(Integer id);

    public void updateUser(User user);

    public void delUsersById(String[] ids);

    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition);
}
