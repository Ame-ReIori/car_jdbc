package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * user entity
 * @author ame
 * @description: this entity describes user
 */
@Getter
@Setter
@Data
@Table(name = "user")
public class User implements Serializable {
    /**
     * primary key
     * auto-increase
     */
    @Pk
    private Long id;

    /**
     * username
     */
    private String username;

    /**
     * password encrypted
     */
    private String password;

    /**
     * salt
     */
    private String salt;

    /**
     * phone
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * money
     */
    private Long money;

    /**
     * email
     */
    private String email;

    /**
     * identity number
     */
    @Column(name = "identity_number")
    private String identityNumber;

    /**
     * status: -1 means deleted, 0 means banned, 1 means usable
     */
    private Integer status;

    /**
     * create time
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * last log in time
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * last update time
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * mac use sha-256
     */
    private String mac;

}
