package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.yygq.demo.dao.OperationRecordDao;
import com.yygq.demo.entity.OperationRecord;
import com.yygq.demo.service.OperationRecordService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationRecordServiceImpl implements OperationRecordService {

    private final OperationRecordDao operationRecordDao;

    @Autowired
    public OperationRecordServiceImpl(OperationRecordDao operationRecordDao){
        this.operationRecordDao = operationRecordDao;
    }

    public Boolean insert(OperationRecord operationRecord){
        return operationRecordDao.insert(operationRecord) > 0;
    }

    public Boolean delete(Long id){
        return operationRecordDao.delete(id) > 0;
    }

    public Boolean update(OperationRecord operationRecord, Long id){
        OperationRecord exist = getOperationRecord(id);
        BeanUtil.copyProperties(operationRecord, exist, CopyOptions.create().setIgnoreNullValue(true));
        return operationRecordDao.update(exist, id) > 0;
    }

    public OperationRecord getOperationRecord(Long id){
        return operationRecordDao.selectById(id);
    }

    public List<OperationRecord> getOperationRecords(OperationRecord operationRecord){
        return operationRecordDao.selectOperationRecordList(operationRecord);
    }

    public List<OperationRecord> getAll(){
        return operationRecordDao.selectAll();
    }
}
