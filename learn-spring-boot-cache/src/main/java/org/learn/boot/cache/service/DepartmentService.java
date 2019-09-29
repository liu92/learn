package org.learn.boot.cache.service;

import org.learn.boot.cache.mapper.DepartmentMapper;
import org.learn.boot.cache.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DepartmentService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/26 14:59
 * History:
 * @<version> 1.0
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    /**
     *
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept")
    public Department getById(Integer id){
        System.out.println("查询部门" + id);
        Department department = departmentMapper.getById(id);
        return  department;
    }
}
