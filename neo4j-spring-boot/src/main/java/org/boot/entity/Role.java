package org.boot.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Role
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/5/14 11:02
 **/
@NodeEntity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private List<String> roles = new ArrayList<>();

    @StartNode
    private Person person;

    @EndNode
    private Movie movie;

    public void addRoleName(String name) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(name);
    }

    public Role(){}

    public Role(Movie movie, Person person){
        this.movie = movie;
        this.person = person;
    }
}
