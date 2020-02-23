package com.hzau.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author su
 * @description JedisPool工具类
 * @date 2020/2/23
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;
    private static String password;
    static {
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
        password = pro.getProperty("password");
    }
    public static Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        jedis.auth(password);
        return jedis;
    }
}
