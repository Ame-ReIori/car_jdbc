package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * order entity
 *
 * @author ame
 */
@Data
@Table(name = "ORDER_TABLE")
public class Order {
    /**
     * id
     */
    @Pk(name = "ORDER_ID")
    @Column(name = "ORDER_ID")
    private String orderId;

    /**
     * create time
     */
    @Column(name = "CREATED_TIME")
    private Date createTime;

    /**
     * car id
     */
    @Column(name = "CAR_ID")
    private Long carId;

    /**
     * the id of customer
     */
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    /**
     * the id of seller
     */
    @Column(name = "SALER_ID")
    private Long salerId;

    /**
     * deal price
     */
    @Column(name = "DEAL_PRICE")
    private Long dealPrice;


    /**
     * status of order
     */
    @Column(name = "ORDER_STATE")
    private String orderStatus;
}
