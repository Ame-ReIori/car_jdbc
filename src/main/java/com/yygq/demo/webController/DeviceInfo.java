package com.yygq.demo.webController;
/*
 * rec_DeviceInfo
 * @author:tfountain
 * */
public class DeviceInfo {
    private int post_code;
    private long user_id;
    private String user_name;
    private String password;
    private String mail;
    private String phone;

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setPost_code(int post_code) {
        this.post_code = post_code;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone_upda) {
        this.phone = phone;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPost_code() {
        return post_code;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public long getUser_id() {
        return user_id;
    }

}
