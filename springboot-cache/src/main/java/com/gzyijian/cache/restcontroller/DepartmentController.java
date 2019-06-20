package com.gzyijian.cache.restcontroller;

import com.gzyijian.cache.bean.Department;
import com.gzyijian.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    @GetMapping("/api/department/{id}")
    public Department get(@PathVariable Integer id) {
        return deptService.getById(id);
    }
}
