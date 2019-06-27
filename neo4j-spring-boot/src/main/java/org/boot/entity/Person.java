package org.boot.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Person
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/5/14 10:59
 **/
@NodeEntity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int born;

    @Relationship(type ="ACTED_IN")
    private List<Movie> movies = new ArrayList<>();

    public Person(){}

    public Person(String name,int born){
        this.name = name;
        this.born = born;
    }

}
