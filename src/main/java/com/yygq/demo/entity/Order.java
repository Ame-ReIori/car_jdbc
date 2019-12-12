package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
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
    @Column(name = "create_time")
    private Date createTime;

    /**
     * the id of customer
     */
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * the id of seller
     */
    @Column(name = "seller_id")
    private Long sellerId;

    /**
     * deal price
     */
    private Long price;

    /**
     * car id
     */
    @Column(name = "car_id")
    private Long catId;
    /**
     * status of order
     */
    private String status;
}
