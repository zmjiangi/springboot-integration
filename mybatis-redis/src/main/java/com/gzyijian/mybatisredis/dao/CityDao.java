package com.gzyijian.mybatisredis.dao;

import com.gzyijian.mybatisredis.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * @author zmjiangi
 * @date 2019-6-18
 */
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAll();

    /**
     * 根据城市 ID , 获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    /**
     * 保存
     *
     * @param city
     * @return
     */
    Long save(City city);

    /**
     * 更新
     *
     * @param city
     * @return
     */
    Long update(City city);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Long delete(Long id);

}
