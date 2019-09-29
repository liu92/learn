package org.learn.boot.cache.controller;

import org.learn.boot.cache.po.Employee;
import org.learn.boot.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EmployeeController
 * @Description:
 * @Author: lin
 * @Date: 2019/9/25 20:59
 * History:
 * @<version> 1.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getById(@PathVariable("id") Integer id){
        Employee e = employeeService.getById(id);
        return e;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        Employee update = employeeService.update(employee);
        return  update;
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        employeeService.delete(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getByLastName(@PathVariable("lastName") String lastName){
        Employee byLastName = employeeService.getByLastName(lastName);
        return byLastName;
    }
}
