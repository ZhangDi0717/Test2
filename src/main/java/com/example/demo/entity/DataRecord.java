package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "datarecord")
public class DataRecord {
    /**
     *   GeneratedValue；
     *
         public enum GenerationType{
         TABLE,         //使用一个特定的数据库表格来保存主键。
         SEQUENCE,      //根据底层数据库的序列来生成主键，条件是数据库支持序列。
         IDENTITY,      //主键由数据库自动生成（主要是自动增长型）
         AUTO           //主键由程序控制。
         }
     *
     */

    /**
     * Id ：标定主键
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer datarecord_id;



    private Double upvalue;
    private Double mdvalue;
    private Double lwvalue;

    private Date time;

    /**
     * view  ->  persistence->*****
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Sensor sensor;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Integer getDatarecord_id() {
        return datarecord_id;
    }

    public void setDatarecord_id(Integer datarecord_id) {
        this.datarecord_id = datarecord_id;
    }

    public Double getUpvalue() {
        return upvalue;
    }

    public void setUpvalue(Double upvalue) {
        this.upvalue = upvalue;
    }

    public Double getMdvalue() {
        return mdvalue;
    }

    public void setMdvalue(Double mdvalue) {
        this.mdvalue = mdvalue;
    }

    public Double getLwvalue() {
        return lwvalue;
    }

    public void setLwvalue(Double lwvalue) {
        this.lwvalue = lwvalue;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
