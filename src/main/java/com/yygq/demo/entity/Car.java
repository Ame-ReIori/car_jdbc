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
    @Pk(name = "CAR_ID")
    @Column(name = "CAR_ID")
    private Long carId;

    /**
     * image's url
     */
    @Column(name = "PICTURE")
    private String picture;

    /**
     * detail images' url
     */
    @Column(name = "DETAIL_IMAGE1")
    private String detailImage1;
    @Column(name = "DETAIL_IMAGE2")
    private String detailImage2;
    @Column(name = "DETAIL_IMAGE3")
    private String detailImage3;
    @Column(name = "DETAIL_IMAGE4")
    private String detailImage4;

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
    private String ownerTel;

    /**
     * price
     */
    @Column(name = "PRICE")
    private Long price;

    /**
     * transfer times
     */
    @Column(name = "TRANSFER_TIME")
    private Integer transferTime;

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
