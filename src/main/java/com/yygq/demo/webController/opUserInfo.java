package com.yygq.demo.webController;

public class opUserInfo {
    private int post_code;
    private long op_user_ID;
    private long admin_id;

    public long getOp_user_ID() {
        return op_user_ID;
    }

    public void setOp_user_ID(long op_user_ID) {
        this.op_user_ID = op_user_ID;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setPost_code(int post_code) {
        this.post_code = post_code;
    }

    public int getPost_code() {
        return post_code;
    }
}
