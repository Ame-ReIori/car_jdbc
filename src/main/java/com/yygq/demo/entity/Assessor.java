package com.yygq.demo.entity;

import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

@Data
@Table(name = "assessor")
public class Assessor {
    /**
     * id
     */
    @Pk
    private Long id;

    /**
     * real name
     */
    private String realName;

    /**
     * password
     */
    private String password;

    /**
     * salt
     */
    private String salt;

    /**
     * phone number
     */
    private String phoneNumber;

    /**
     * level
     */
    private Long level;

    /**
     * identity number
     */
    private String identityNumber;

    /**
     * email
     */
    private String email;
}
