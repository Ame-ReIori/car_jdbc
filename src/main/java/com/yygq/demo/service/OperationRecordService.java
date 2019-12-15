package com.yygq.demo.service;

import com.yygq.demo.entity.OperationRecord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * operation record service
 * @author ame
 */
@Service
public interface OperationRecordService {

    /**
     * insert
     * need operation and admin_id from web definitely
     * @param operationRecord
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(OperationRecord operationRecord);

    /**
     * delete
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(Long id);

    /**
     * update
     * @param operationRecord
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(OperationRecord operationRecord, Long id);

    /**
     * get one
     * @param id
     * @return one operation record
     */
    OperationRecord getOperationRecord(Long id);

    /**
     * get like operationRecord
     * @param operationRecord
     * @return list of operation records
     */
    List<OperationRecord> getOperationRecords(OperationRecord operationRecord);

    /**
     * get all
     * @return list of operation records
     */
    List<OperationRecord> getAll();
}
