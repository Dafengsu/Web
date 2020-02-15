package hzau.jdbctemplate;

import hzau.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @description:
 * @author: su
 * @date: 2020/2/14
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "UPDATE emp SET salary = 10000 where ename = ?";
        int count = template.update(sql, "孙悟空");
        System.out.println(count);
    }
}
