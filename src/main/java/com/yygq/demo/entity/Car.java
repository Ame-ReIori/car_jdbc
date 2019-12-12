package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

/**
 * car entity
 *
 * @author ame
 */
@Data
@Table(name = "car")
public class Car {
    /**
     * id
     */
    @Pk
    private Long id;

    /**
     * image's url
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * detail images' url
     */
    @Column(name = "detail_img_url_0")
    private String detailImgUrl0;
    @Column(name = "detail_img_url_1")
    private String detailImgUrl1;
    @Column(name = "detail_img_url_2")
    private String detailImgUrl2;
    @Column(name = "detail_img_url_3")
    private String detailImgUrl3;

    /**
     * type of car
     */
    @Column(name = "car_type")
    private String carType;

    /**
     * the owner of car
     */
    @Column(name = "owner_id")
    private Long ownerId;

    /**
     * the phone of owner
     */
    @Column(name = "owner_phone")
    private String ownerPhone;

    /**
     * price
     */
    private Long price;

    /**
     * car status
     */
    private String status;

    /**
     * transfer times
     */
    @Column(name = "transfer_time")
    private Long transferTime;
}
