package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "insurance")
public class Insurance {
    /**
     * id
     */
    @Pk
    private String id;

    /**
     * company
     */
    private String company;

    /**
     * the id of car
     */
    @Column(name = "car_id")
    private Long carId;

    /**
     * the id of owner
     */
    @Column(name = "owner_id")
    private Long ownerId;

    /**
     * insurance time
     */
    @Column(name = "insure_time")
    private Date insureTime;

    /**
     * the type of insurance
     */
    @Column(name = "insure_type")
    private String insureType;

    /**
     * ddl
     */
    private Date ddl;
}
