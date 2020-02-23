package com.hzau.test;

import com.hzau.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
public class JedisTest {
    @Test
    public void test1() {
        //1.获取连接
        Jedis jedis = new Jedis("106.14.81.119", 6379);
        //2.操作
        jedis.auth("@Dafengsu2020");
        jedis.set("username", "张三");
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void test2() {
        //1.获取连接
        Jedis jedis = new Jedis("106.14.81.119", 6379);
        //2.操作
        jedis.auth("@Dafengsu2020");
        String username = jedis.get("username");
        System.out.println(username);
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void test3() {
        //1.获取连接
        Jedis jedis = new Jedis("106.14.81.119", 6379);
        //2.操作
        jedis.auth("@Dafengsu2020");
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "a", "b", "c");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void test4() {
        JedisPool jedisPool = new JedisPool("106.14.81.119", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("@Dafengsu2020");
        jedis.zadd("mySortSet", 30, "zhangsan");
        jedis.zadd("mySortSet", 10, "李四");
        jedis.zadd("mySortSet", 20, "王五");
        Set<String> mySortSet = jedis.zrange("mySortSet", 0, -1);
        System.out.println(mySortSet);
        jedis.close();
    }

    @Test
    public void test5() {
        Jedis jedis = JedisPoolUtils.getJedis();
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        jedis.close();
    }
}
