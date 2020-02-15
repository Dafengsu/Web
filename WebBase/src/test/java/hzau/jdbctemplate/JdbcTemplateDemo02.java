package hzau.jdbctemplate;

import hzau.domain.Emp;
import hzau.utils.JDBCUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: su
 * @date: 2020/2/14
 */
public class JdbcTemplateDemo02 {
    private  JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test1() {
        String sql = "UPDATE emp SET salary = 10000 where ename = ?";
        int count = template.update(sql, "孙悟空");
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2() {
        String sql = "INSERT emp(id,ename,dept_id) VALUES (?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        Assert.assertEquals(count, 1);
    }

    @Test
    public void test3() {
        String sql = "DELETE  FROM emp WHERE id = ?";
        int count = template.update(sql, 1015);
        Assert.assertEquals(count, 1);
    }

    @Test
    public void test4() {
        String sql = "SELECT * FROM emp WHERE id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    @Test
    public void test5() {
        String sql = "SELECT * FROM emp";

        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void test6() {
        String sql = "SELECT * FROM emp";

        List<Emp> empList = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;

            }
        });
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void test6_2(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
