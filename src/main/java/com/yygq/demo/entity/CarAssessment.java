package com.yygq.demo.entity;

import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Table;
import lombok.Data;

@Data
@Table(name = "car_assessment")
public class CarAssessment {
    /**
     * id
     */
    @Pk
    private String id;

    /**
     * the id of assessment
     */
    @Column(name = "assessment_id")
    private Long assessmentId;

    /**
     * the id of admin
     */
    @Column(name = "admin_id")
    private Long adminId;

    /**
     * the status of some parts
     */
    @Column(name = "engine_status")
    private String engineStatus;

    @Column(name = "window_status")
    private String windowStatus;

    @Column(name = "wheel_status")
    private String wheelStatus;

    @Column(name = "collision_status")
    private String collisionStatus;

    @Column(name = "light_status")
    private String lightStatus;

    @Column(name = "appearance_status")
    private String appearanceStatus;

    @Column(name = "dashboard_status")
    private String dashboardStatus;

    @Column(name = "chassis status")
    private String chassisStatus;

    @Column(name = "sec_sys_status")
    private String secSysStatus;
}
