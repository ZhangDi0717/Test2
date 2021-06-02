package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensor_id;

    private String sensor_name;

    //以下进行下一步
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sensor")
    private Collection<DataRecord> records = new HashSet<>();

    public Collection<DataRecord> getRecords() {
        return records;
    }

    public void setRecords(Collection<DataRecord> records) {
        this.records = records;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }
}
