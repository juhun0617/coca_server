package com.example.coca_server.Model;

import org.springframework.web.multipart.MultipartFile;

public class ImgRequest {

    private String membername;

    private String memberpassword;

    private MultipartFile img;


    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMemberpassword() {
        return memberpassword;
    }

    public void setMemberpassword(String memberpassword) {
        this.memberpassword = memberpassword;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public ImgRequest() {
    }

    public ImgRequest(String membername, String memberpassword, MultipartFile img) {
        this.membername = membername;
        this.memberpassword = memberpassword;
        this.img = img;
    }
}
