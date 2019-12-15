package com.yygq.demo.webController;
/*
 * rec_makeAssessment
 * @author:tfountain
 * */
public class MakeAssessment {
    private long assessor_id;
    private long car_id;
    private String engine_as;
    private String windows_as;
    private String wheels_as;
    private String collsion_as;
    private String lights_as;
    private String appearance_as;
    private String dashboard_as;
    private String chassis_as;
    private String security_system_as;

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    public long getAssessor_id() {
        return assessor_id;
    }

    public long getCar_id() {
        return car_id;
    }

    public String getAppearance_as() {
        return appearance_as;
    }

    public String getChassis_as() {
        return chassis_as;
    }

    public String getCollsion_as() {
        return collsion_as;
    }

    public String getDashboard_as() {
        return dashboard_as;
    }

    public String getEngine_as() {
        return engine_as;
    }

    public String getLights_as() {
        return lights_as;
    }

    public String getSecurity_system_as() {
        return security_system_as;
    }

    public String getWheels_as() {
        return wheels_as;
    }

    public String getWindows_as() {
        return windows_as;
    }

    public void setAppearance_as(String appearance_as) {
        this.appearance_as = appearance_as;
    }

    public void setAssessor_id(long assessor_id) {
        this.assessor_id = assessor_id;
    }

    public void setChassis_as(String chassis_as) {
        this.chassis_as = chassis_as;
    }

    public void setCollsion_as(String collsion_as) {
        this.collsion_as = collsion_as;
    }

    public void setDashboard_as(String dashboard_as) {
        this.dashboard_as = dashboard_as;
    }

    public void setEngine_as(String engine_as) {
        this.engine_as = engine_as;
    }

    public void setLights_as(String lights_as) {
        this.lights_as = lights_as;
    }

    public void setSecurity_system_as(String security_system_as) {
        this.security_system_as = security_system_as;
    }

    public void setWheels_as(String wheels_as) {
        this.wheels_as = wheels_as;
    }

    public void setWindows_as(String windos_as) {
        this.windows_as = windos_as;
    }

}
