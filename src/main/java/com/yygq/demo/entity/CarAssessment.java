package com.yygq.demo.entity;

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
    private Long assessmentId;

    /**
     * the id of admin
     */
    private Long adminId;

    /**
     * the status of some parts
     */
    private String engineStatus;

    private String windowStatus;

    private String wheelStatus;

    private String collisionStatus;

    private String lightStatus;

    private String appearanceStatus;

    private String dashboardStatus;

    private String chassisStatus;

    private String secSysStatus;
}
