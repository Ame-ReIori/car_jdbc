package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * assessor entity
 *
 * @author ame
 */
@Data
@Table(name = "ASSESSOR_TABLE")
public class Assessor  implements Serializable {
    /**
     * id
     */
    @Pk(name = "ASSESS_ID")
    @Column(name = "ASSESS_ID")
    private Long assessId;

    /**
     * real name
     */
    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private int status;

    /**
     * password
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * salt
     */
    @Column(name = "SALT")
    private String salt;

    /**
     * phone number
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * level
     */
    @Column(name = "LEVEL")
    private String level;

    /**
     * identity number
     */
    @Column(name = "IDENTITY_NUMBER")
    private String identityNumber;

    /**
     * email
     */
    @Column(name = "EMAIL")
    private String email;
}
