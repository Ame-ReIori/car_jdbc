package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

/**
 * operation entity
 *
 * @author ame
 */
@Data
@Table(name = "OP_RECORD_TABLE")
public class OperationRecord {
    /**
     * record id
     */
    @Pk
    @Column(name = "RECORD_ID")
    private Long recordId;

    /**
     * operation
     */
    @Column(name = "OPERATION")
    private String operation;

    /**
     * administer id
     */
    @Column(name = "ADMIN_ID")
    private String adminId;
}
