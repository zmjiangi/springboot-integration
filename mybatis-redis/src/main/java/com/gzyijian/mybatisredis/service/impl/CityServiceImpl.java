package com.gzyijian.mybatisredis.service.impl;

import com.gzyijian.mybatisredis.dao.CityDao;
import com.gzyijian.mybatisredis.domain.City;
import com.gzyijian.mybatisredis.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 城市业务逻辑实现类
 *
 * @author zmjiangi
 * @date 2019-6-18
 */
@Service("cityService")
public class CityServiceImpl implements CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    @Override
    public City findById(Long id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);

            LOGGER.info("CityServiceImpl.findById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityDao.findById(id);

        // 插入缓存
        operations.set(key, city, 10, TimeUnit.SECONDS);

        LOGGER.info("CityServiceImpl.findById() : 城市插入缓存 >> " + city.toString());

        return city;
    }

    @Override
    public Long save(City city) {
        return cityDao.save(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Long update(City city) {
        Long ret = cityDao.update(city);

        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.update() : 从缓存中删除城市 >> " + city.toString());
        }

        return ret;
    }

    @Override
    public Long delete(Long id) {

        Long ret = cityDao.delete(id);

        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.delete() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }

}
