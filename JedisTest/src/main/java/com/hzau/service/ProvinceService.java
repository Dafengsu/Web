package com.hzau.service;

import com.hzau.domain.Province;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
