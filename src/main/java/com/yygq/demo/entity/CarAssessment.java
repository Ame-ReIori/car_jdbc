package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

/**
 * car assessment entity
 *
 * @author ame
 */
@Data
@Table(name = "CAR_DETECTION_TABLE")
public class CarAssessment {
    /**
     * id
     */
    @Pk
    @Column(name = "CAR_ID")
    private Long carId;

    /**
     * the id of assessment
     */
    @Column(name = "ASSESSOR_ID")
    private Long assessmentId;

    /**
     * the id of admin
     */
    @Column(name = "ADMIN_ID")
    private Long adminId;

    /**
     * the status of some parts
     */
    @Column(name = "ENGINE")
    private String engine;

    @Column(name = "WINDOWS")
    private String window;

    @Column(name = "WHEELS")
    private String wheel;

    @Column(name = "COLLISION")
    private String collision;

    @Column(name = "LIGHTS")
    private String light;

    @Column(name = "APPEARANCE")
    private String appearance;

    @Column(name = "DASHBOARD")
    private String dashboard;

    @Column(name = "CHASSIS")
    private String chassis;

    @Column(name = "SECURITY_SYSTEM")
    private String securitySystem;
}
