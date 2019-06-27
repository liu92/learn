package org.boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Movie
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/5/14 10:59
 **/
@NodeEntity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int released;

    private String tagline;

    @JsonIgnoreProperties("movie")
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<Role> roles ;

    public Movie(){}

    public Movie(String title, int released, String tagline) {
        this.title = title;
        this.released = released;
        this.tagline = tagline;
    }

    public void addRole(Role role) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
    }
}
