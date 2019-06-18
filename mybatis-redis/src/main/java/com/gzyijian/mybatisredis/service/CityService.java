package com.gzyijian.mybatisredis.service;

import com.gzyijian.mybatisredis.domain.City;

/**
 * 城市业务逻辑接口类
 *
 * @author zmjiangi
 * @date 2019-6-18
 */
public interface CityService {
    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    City findById(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long save(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long update(City city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    Long delete(Long id);
}
