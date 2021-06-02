package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "Teachers")
    private Collection<classs> Banjies;

    public Collection<classs> getBanjies() {
        return Banjies;
    }

    public void setBanjies(Collection<classs> banjies) {
        Banjies = banjies;
    }
}
