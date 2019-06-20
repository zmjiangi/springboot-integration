package com.gzyijian.cache.restcontroller;

import com.gzyijian.cache.bean.Employee;
import com.gzyijian.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/employee/{id}")
    public Employee get(@PathVariable("id") Integer id) {
        Employee employee = employeeService.get(id);
        return employee;
    }

    @PutMapping("/api/employee")
    public Employee update(Employee employee) {
        Employee emp = employeeService.update(employee);

        return emp;
    }

    @DeleteMapping("/api/employee/delete")
    public String delete(Integer id) {
        employeeService.delete(id);
        return "success";
    }

    @GetMapping("/api/emp/employee/{lastName}")
    public Employee getEmpByLastName(@PathVariable String lastName) {
        return employeeService.getByLastName(lastName);
    }

}
