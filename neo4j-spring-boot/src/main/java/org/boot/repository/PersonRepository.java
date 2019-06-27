package org.boot.repository;

import org.boot.entity.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: person 接口类
 * <br/>
 * @Date: 2019/5/14 11:57
 * @Author: liuwanlin
 * @return:
 **/
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    /**
     * 功能描述: <br>
     *
     * @param name
     * @return:
     * @since: 1.0.0
     * @Author:lin
     * @Date: 2019/5/14 23:32
     */

    Person findByName(String name);

   /**
    * 添加用户
    * @Description
    * @param name
    * @param born
    * @return java.util.List<org.boot.entity.Person>
    * @exception
    * @author lin
    * @Date 23:41 2019/5/14
    **/
   @Query("CREATE (p:Person{name:{name},born:{born}}) RETURN p")
    List<Person> addPerson(String name, int born);
}
