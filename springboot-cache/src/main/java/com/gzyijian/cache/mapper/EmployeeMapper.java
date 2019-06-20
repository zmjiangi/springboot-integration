package com.gzyijian.cache.mapper;

import com.gzyijian.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},departmentId=#{departmentId} WHERE id=#{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    void insert(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getByLastName(String lastName);

}
