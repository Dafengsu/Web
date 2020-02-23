package com.hzau.dao.impl;

import com.hzau.dao.ProvinceDao;
import com.hzau.domain.Province;
import com.hzau.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "SELECT * FROM province";
        return template.query(sql,
                new BeanPropertyRowMapper<>(Province.class));
    }

}
