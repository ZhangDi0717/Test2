package com.example.demo.entity;


import javax.persistence.*;


@Entity
@Table(name = "student") // 不配置为驼峰
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    private Integer old;

    public Student() {
    }

    public Student(String name, Integer old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", old=" + old +
                '}';
    }

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

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private classs Banjie;

    public classs getBanjie() {
        return Banjie;
    }

    public void setBanjie(classs banjie) {
        Banjie = banjie;
    }
}
