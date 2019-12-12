package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * administer entity
 *
 * @author ame
 */
@Data
@Table(name = "ADMIN_TABLE")
public class Administer {
    /**
     * id
     */
    @Pk
    @Column(name = "ADMIN_ID")
    private Long adminId;

    /**
     * admin's name
     */
    @Column(name = "NAME")
    private String username;

    /**
     * admin's pw
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * salt
     */
    @Column(name = "salt")
    private String salt;

    /**
     * phone
     */
    @Column(name = "PHONE")
    private String phone;

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
     * email
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * create time
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * last login time
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
