package org.learn.boot.cache.controller;

import org.learn.boot.cache.po.Department;
import org.learn.boot.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DepartmentController
 * @Description:
 * @Author: lin
 * @Date: 2019/9/26 15:03
 * History:
 * @<version> 1.0
 */
@RestController()
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @GetMapping("/depart/{id}")
    public Department getById(@PathVariable("id") Integer id) {
        return departmentService.getById(id);
    }
}
