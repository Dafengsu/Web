package com.hzau.dao;

import com.hzau.domain.User;
import com.hzau.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @description:
 * @author: su
 * @date: 2020/2/18
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     *
     * @param loginUser 只有用户名和密码
     * @return 包含用户所有的数据
     */
    public User login(User loginUser) {
        String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";
        User user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class)
                    , loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
