package com.example.demo.controller;

import com.example.demo.dao.DataRecordImpl;
import com.example.demo.dao.SensorImpl;
import com.example.demo.entity.DataRecord;
import com.example.demo.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping(value = "/testtwo")

    @ResponseBody
    public String testtwo(){

        //创建数据记录1
        DataRecord dataRecord1 = new DataRecord();
        dataRecord1.setLwvalue(12.1);
        dataRecord1.setMdvalue(12.2);
        dataRecord1.setUpvalue(12.3);

        //创建数据记录2
        DataRecord dataRecord2 = new DataRecord();
        dataRecord2.setLwvalue(12.3);
        dataRecord2.setMdvalue(12.4);
        dataRecord2.setUpvalue(12.5);

        //创建传感器
        Sensor sensor = new Sensor();
        sensor.setSensor_name("three");



        //将数据记录注册到传感器
        dataRecord1.setSensor(sensor);
        dataRecord2.setSensor(sensor);

        //将传感器注册到数据记录
        sensor.getRecords().add(dataRecord1);
        sensor.getRecords().add(dataRecord2);

        //保存（只保存父表就Ok了）
        sensorimpl.save(sensor);



        return "oktwo";
    }

    //接口实体化
    @Autowired
    DataRecordImpl dataRecordimpl;

    @Autowired
    SensorImpl sensorimpl;
}
