package com.yygq.demo.entity;

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
    private Long carId;

    /**
     * the id of owner
     */
    private Long ownerId;

    /**
     * insurance time
     */
    private Date insureTime;

    /**
     * the type of insurance
     */
    private String insureType;

    /**
     * ddl
     */
    private Date ddl;
}
