package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "classs")
public class classs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "Banjie")
    private Collection<Student> Students;

    public Collection<Student> getStudents() {
        return Students;
    }

    public void setStudents(Collection<Student> students) {
        Students = students;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Teacher> Teachers;

    public Collection<Teacher> getTeachers() {
        return Teachers;
    }

    public void setTeachers(Collection<Teacher> teachers) {
        Teachers = teachers;
    }
}
