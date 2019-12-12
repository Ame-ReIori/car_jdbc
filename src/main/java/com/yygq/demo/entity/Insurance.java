package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * insurance entity
 *
 * @author ame
 */
@Data
@Table(name = "INSURANCE_TABLE")
public class Insurance {
    /**
     * id
     */
    @Pk
    @Column(name = "INSURE_ID")
    private String insureId;

    /**
     * company
     */
    @Column(name = "G_COMPANY")
    private String company;

    /**
     * the type of insurance
     */
    @Column(name = "INSURE_TYPECODE")
    private String insureType;

    /**
     * the id of car
     */
    @Column(name = "CAR_ID")
    private Long carId;

    /**
     * the id of owner
     */
    @Column(name = "OWNER_ID")
    private Long ownerId;

    /**
     * insurance time
     */
    @Column(name = "INSURE_TIME")
    private Date insureTime;

    /**
     * ddl
     */
    @Column(name = "DEADLINE")
    private Date ddl;
}
