package com.example.demo.dao;

import com.example.demo.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *  Sensor: 接口需要封装的实体类
 *  Integer:实体类的ID
 */
public interface SensorImpl extends JpaRepository<Sensor,Integer> {

}
