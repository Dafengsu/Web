package com.hzau.dao.impl;

import com.hzau.dao.UserDao;
import com.hzau.domain.User;
import com.hzau.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM USER";
        List<User> users = template.query(sql,
                new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User finUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "SELECT DISTINCT * FROM USER WHERE username = ? AND password = ? LIMIT 1";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO USER VALUES (NULL,?,?,?,?,?,?,NULL,NULL)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getQq(), user.getAddress(), user.getEmail());
    }

    @Override
    public void delUserById(Integer id) {
        String sql = "DELETE FROM USER WHERE id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "SELECT * FROM USER WHERE id = ?";
        return template.queryForObject(sql,
                new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public void updateUser(User user) {

        String sql = "UPDATE USER SET name=?,gender =?,age=?,address=?,qq=?,email=?WHERE id =?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount() {
        //language=MySQL
        String sql = "SELECT COUNT(*) FROM USER";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "SELECT * FROM USER LIMIT ? ,?";
        return template.query(sql,
                new BeanPropertyRowMapper<>(User.class), start, rows);
    }

}
