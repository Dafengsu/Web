package com.hzau.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzau.dao.ProvinceDao;
import com.hzau.dao.impl.ProvinceDaoImpl;
import com.hzau.domain.Province;
import com.hzau.service.ProvinceService;
import com.hzau.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     *
     * @return
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        if (province_json == null || province_json.length() == 0) {
            //redis无数据
            List<Province> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3 将json数据存入redis
            jedis.set("province", province_json);
            //归还连接
            jedis.close();
        } else {
            System.out.println("redis中有数据");
        }
        return province_json;
    }

}
