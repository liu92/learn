package org.learn.boot.cache.mapper;

import org.apache.ibatis.annotations.*;
import org.learn.boot.cache.po.Employee;

/**
 * 员工mapper
 * @ClassName: EmployeeMapper
 * @Description:
 * @Author: lin
 * @Date: 2019/9/25 20:17
 * History:
 * @<version> 1.0
 */
@Mapper
public interface  EmployeeMapper {

    /**
     * 查询
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getEmployeeById(Integer id);

    /**
     * 更新
     * @param employee
     */
    @Update("update employee set last_name=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} where id=#{id}")
    void update(Employee employee);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from employee where id=#{id}")
    void deleteById(Integer id);

    /**
     * 插入数据
     * @param employee
     */
    @Insert("insert into employee(last_name, email, gender, d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    void insert(Employee employee);

    /**
     * 根据名称查询
     * @param lastName
     * @return
     */
    @Select("select * from employee where last_name = #{lastName}")
    Employee getByName(String lastName);
}





