package com.yygq.demo.webController;
/*
 * rec_UserInfo
 * @author:tfountain
 * */
public class UserInfoPost {
    private int post_code;
    private long user_id;

    public int getPost_code() {
        return post_code;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setPost_code(int post_code) {
        this.post_code = post_code;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
