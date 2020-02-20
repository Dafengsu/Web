package com.hzau.dao;

import com.hzau.domain.User;

import java.util.List;

/**
 * @author su
 * @description 用户操作的Dao
 * @date 2020/2/20
 */
public interface UserDao {
    public List<User> findAll();

    public User finUserByUsernameAndPassword(String username, String password);

    public void addUser(User user);

    public void delUserById(Integer id);

    public User findUserById(Integer id);

    public void updateUser(User user);

    public int findTotalCount();

    public List<User> findByPage(int start, int rows);

}
