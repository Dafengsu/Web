package com.hzau.service.impl;

import com.hzau.dao.UserDao;
import com.hzau.dao.impl.UserDaoImpl;
import com.hzau.domain.PageBean;
import com.hzau.domain.User;
import com.hzau.service.UserService;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.finUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUserById(Integer id) {
        dao.delUserById(id);
    }

    @Override
    public User findUserById(Integer id) {
       return dao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delUsersById(String[] ids) {
        if (ids != null) {
            for (String id : ids) {
                dao.delUserById(Integer.valueOf(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows) {

        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调查总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //查询List集合
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows);
        pb.setList(list);
        int totalPage = totalCount % rows == 0
                ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

}
