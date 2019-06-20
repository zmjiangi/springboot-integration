package com.gzyijian.cache.mapper;

import com.gzyijian.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getById(Integer id);
}
