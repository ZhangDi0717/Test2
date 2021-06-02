package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_shenqing")
public class Shenqing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shenqing_id;
    String name;

    public Integer getShenqing_id() {
        return shenqing_id;
    }

    public void setShenqing_id(Integer shenqing_id) {
        this.shenqing_id = shenqing_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}