package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.lang.annotation.Native;

/**
 * car entity
 *
 * @author ame
 */
@Data
@Table(name = "CAR_TABLE")
public class Car {
    /**
     * id
     */
    @Pk
    @Column(name = "CAR_ID")
    private Long carId;

    /**
     * image's url
     */
    @Column(name = "PICTURE")
    private String imgUrl;

    /**
     * detail images' url
     */
    @Column(name = "DETAIL_IMAGE1")
    private String detailImgUrl0;
    @Column(name = "DETAIL_IMAGE2")
    private String detailImgUrl1;
    @Column(name = "DETAIL_IMAGE3")
    private String detailImgUrl2;
    @Column(name = "DETAIL_IMAGE4")
    private String detailImgUrl3;

    /**
     * type of car
     */
    @Column(name = "CAR_TYPE")
    private String carType;

    /**
     * the owner of car
     */
    @Column(name = "OWNER_ID")
    private Long ownerId;

    /**
     * the phone of owner
     */
    @Column(name = "OWNER_TEL")
    private String ownerPhone;

    /**
     * price
     */
    @Column(name = "PRICE")
    private Long price;

    /**
     * transfer times
     */
    @Column(name = "TRANSFER_TIME")
    private int transferTime;

    /**
     * is sold?
     */
    @Column(name = "IS_SOLD")
    private Boolean isSold;

    /**
     * is assessed?
     */
    @Column(name = "IS_ASSESS")
    private Boolean isAssess;

}
