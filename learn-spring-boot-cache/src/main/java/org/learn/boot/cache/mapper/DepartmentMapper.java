package org.learn.boot.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.learn.boot.cache.po.Department;

/**
 * 部门mapper
 * @ClassName: DepartmentMapper
 * @Description:
 * @Author: lin
 * @Date: 2019/9/25 20:17
 * @History:
 * @<version> 1.0
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from department where id=#{id}")
    Department getById(Integer id);
}
