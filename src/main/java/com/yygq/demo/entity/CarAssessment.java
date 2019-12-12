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
    private String engineStatus;

    @Column(name = "WINDOWS")
    private String windowStatus;

    @Column(name = "WHEELS")
    private String wheelStatus;

    @Column(name = "COLLISION")
    private String collisionStatus;

    @Column(name = "LIGHTS")
    private String lightStatus;

    @Column(name = "APPEARANCE")
    private String appearanceStatus;

    @Column(name = "DASHBOARD")
    private String dashboardStatus;

    @Column(name = "CHASSIS")
    private String chassisStatus;

    @Column(name = "SECURITY_SYSTEM")
    private String secSysStatus;
}
