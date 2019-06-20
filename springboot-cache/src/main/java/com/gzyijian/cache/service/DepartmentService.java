package com.gzyijian.cache.service;

import com.gzyijian.cache.bean.Department;
import com.gzyijian.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;


/**
 * @author zmjiangi
 * @date 2019-6-19
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    private RedisCacheManager deptCacheManager;

    /**
     * 缓存的数据能存入redis；
     * 第二次从缓存中查询就不能反序列化回来；
     * 存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept", cacheManager = "deptCacheManager")
    public Department getById(Integer id) {
        System.out.println("查询部门" + id);
        Department department = departmentMapper.getById(id);
        return department;
    }

    /**
     * 使用缓存管理器得到缓存，进行api调用
     */
///    public Department getById(Integer id) {
//        System.out.println("查询部门" + id);
//        Department department = departmentMapper.getById(id);
//
//        //获取某个缓存
//        Cache dept = deptCacheManager.getCache("dept");
//        dept.put("dept:1", department);
//
//        return department;
//    }


}
