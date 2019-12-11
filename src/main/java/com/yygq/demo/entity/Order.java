package com.yygq.demo.entity;

import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "order")
public class Order {
    /**
     * id
     */
    @Pk
    private String id;

    /**
     * create time
     */
    private Date createTime;

    /**
     * the id of customer
     */
    private Long customerId;

    /**
     * the id of seller
     */
    private Long sellerId;

    /**
     * deal price
     */
    private Long price;

    /**
     * status of order
     */
    private String status;
}
