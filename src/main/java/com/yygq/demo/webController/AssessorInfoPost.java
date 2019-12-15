package com.yygq.demo.webController;

/*
 * recv_AssessorInfo
 * @author:tfountain
 * */
public class AssessorInfoPost {
    private int post_code;
    private long assessor_id;

    public int getPost_code() {
        return post_code;
    }

    public long getAssessor_id() {
        return assessor_id;
    }

    public void setPost_code(int post_code) {
        this.post_code = post_code;
    }

    public void setAssessor_id(long assessor_id) {
        this.assessor_id = assessor_id;
    }
}
