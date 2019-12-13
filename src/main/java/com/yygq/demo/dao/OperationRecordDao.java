package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.OperationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * operation record dao
 * @author ame
 */
@Repository
public class OperationRecordDao extends BaseDao<OperationRecord, Long> {

    @Autowired
    public OperationRecordDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert
     * @param operationRecord
     * @return success number
     */
    public Integer insert(OperationRecord operationRecord){
        return super.insert(operationRecord, true);
    }

    /**
     * delete
     * @param id
     * @return success number
     */
    public Integer delete(Long id){
        return super.deleteById(id);
    }

    /**
     * update
     * @param operationRecord
     * @param id
     * @return success number
     */
    public Integer update(OperationRecord operationRecord, Long id){
        return super.updateById(operationRecord, id, true);
    }

    /**
     * select an operation record
     * @param id
     * @return an operation record entity
     */
    public OperationRecord selectById(Long id){
        return super.queryOneById(id);
    }

    /**
     * select operation records like operationRecord
     * @param operationRecord
     * @return list of operation records
     */
    public List<OperationRecord> selectOperationRecordList(OperationRecord operationRecord){
        return super.queryByExample(operationRecord);
    }

    /**
     * select all
     * @return list of operation records
     */
    public List<OperationRecord> selectAll(){
        return super.queryAll();
    }
}
