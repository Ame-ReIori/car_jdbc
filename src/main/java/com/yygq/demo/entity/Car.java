package com.yygq.demo.entity;

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
    private String imgUrl;

    /**
     * detail images' url
     */
    private String detailImgUrl0;
    private String detailImgUrl1;
    private String detailImgUrl2;
    private String detailImgUrl3;

    /**
     * type of car
     */
    private String carType;

    /**
     * the owner of car
     */
    private Long owner_id;

    /**
     * the phone of owner
     */
    private String owner_phone;

    /**
     * price
     */
    private Long price;

    /**
     * transfer times
     */
    private Long transferTime;
}
