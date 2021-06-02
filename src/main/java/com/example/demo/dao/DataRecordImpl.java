package com.example.demo.dao;

import com.example.demo.entity.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DataRecord的接口：
 *
 */
public interface DataRecordImpl extends JpaRepository<DataRecord,Integer> {
}
