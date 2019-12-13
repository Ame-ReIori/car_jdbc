package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user entity
 * @author ame
 * @description: this entity describes user
 */

@Data
@Table(name = "USER_TABLE")
public class User implements Serializable {
    /**
     * primary key
     * auto-increase
     */
    @Pk
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * username
     */
    @Column(name = "NAME")
    private String name;

    /**
     * password encrypted
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * salt
     */
    @Column(name = "SALT")
    private String salt;

    /**
     * phone
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * money
     */
    @Column(name = "MONEY")
    private Long money;

    /**
     * email
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * identity number
     */
    @Column(name = "IDENTITY_NUMBER")
    private String identityNumber;

    /**
     * real name
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * status: -1 means deleted, 0 means banned, 1 means usable
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * create time
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * last log in time
     */
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
     * last update time
     */
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    /**
     * mac use sha-256
     */
    @Column(name = "MAC")
    private String mac;

    /**
     * avatar
     */
    @Column(name = "AVATAR")
    private String avatar;

}
