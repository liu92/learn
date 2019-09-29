package org.learn.boot.cache.service;

import org.learn.boot.cache.mapper.EmployeeMapper;
import org.learn.boot.cache.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 员工 service
 * @ClassName: EmployeeService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/25 20:57
 * History:
 * @<version> 1.0
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     *  在方法上添加@Cacheable 注解，是将方法的运行 结果进行缓存，以后再要相同的数据，直接从缓存中获取，不在调用方法。
     *  CacheManager管理 多个Cache组件的，对缓存的真正CRUD操作在Cache组件中。每一个缓冲组件有自己唯一一个名字；
     *         cacheNames/value :指定缓存组件的名字；
     *         key: 缓存数据使用的key: 可以用它来指定，默认使使用方法参数的值， 如果传入的1,那么 值就是这个方法的返回值。
     *         编写SpEl ; #id 参数id的值， # a0, #p0, #root.args[0]
     *         自定义key : getById[2] 这种可以在下面进行拼接， key = "#root.methodName+'['+#root.id+']'"
     *
     *         keyGenerator: key的生成器; 可以指定key的生成器的组件id。
     *              key/keyGenerator：二选使用 , 在下面的key = "mykeyGenerator" 这个指定自定义的 keyGenerator。
     *
     * 查询
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"} /* key = "#root.methodName+'['+#root.id+']'"*/)
    public Employee getById(Integer id){
        // 在没有加入缓存注解时，这个打印语句 在每调用一次时都会 打印。
        // 但是当加入 缓存注解后，只有第一次请求时进行打印，其再次请求都不会打印
        System.out.println("查询" + id + "号员工");
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }


    /**
     * @CachePut: 即调用方法，又更新缓存数据, 同步更新缓存。
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     *
     *  测试步骤
     *    a、先查询1号员工，查到的结果会放到缓存中 ，
     *       key:1. value: lastname：张三
     *      以后查询还是之前的结果
     *    b、更新1号 员工；[lastNme: lisi; gender:0]
     *           key: 传入的employee对象， 值： 放回的employee对象
     *    c、查询1号员工？
     *           应该是更新后的员工，
     *               key = "#employee.id": 使用传入的参数的员工id
     *               key="#result.id"; 使用返回后的id
     *                @Cacheable的key 是不能用#result，因为这个是根据一个key去检查缓存，还没有得到结果之前，就有得到这个key.
     *           但是为什么是没有更新前的？因为存入key 不一样
     * @return
     */
    @CachePut(cacheNames ="emp",key = "#employee.id")
    public Employee update(Employee employee){
       employeeMapper.update(employee);
       return  employee;
    }


    /**
     * @CacheEvict:清除缓存
     *    key: 指定要清除的数据
     *  allEntries=true: 清除所有缓存
     *  beforeInvocation=false :缓存的清除是否在方法之前执行
     *    默认代表缓存清除操作是在方法执行之后执行， 如果出现异常 缓存就不会被清除，
     *   beforeInvocation=true;
     *    代表缓存清除操作是在方法执行之前执行，无论方法是否出现异常， 缓存也会被删除
     * 删除一个员工
     */
    @CacheEvict(cacheNames = "emp", key = "#id")
    public void  delete(Integer id){
        System.out.println("delete:" +id);
    }


    /**
     *   @Caching 定义复杂的缓存规则
     *
     *   在这些注解中都有相同的 cacheNames = "emp",
     *    所以我们可以在类上面进行统一的配置 @CacheConfig(value="emp") 来表示抽取缓存的统一配置
     *
     * @param lastName
     * @return
     */

    @Caching(
            cacheable = {@Cacheable(value = "emp", key = "#lastName")
            },
            put = {@CachePut(value = "emp", key = "#result.id"),
                   @CachePut(value = "emp", key = "#result.email")})
    public Employee getByLastName(String lastName){
        Employee byName = employeeMapper.getByName(lastName);
        return  byName;
    }
}
