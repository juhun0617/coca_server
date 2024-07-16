package com.example.coca_server.Model;

import org.springframework.web.multipart.MultipartFile;

public class RecommendResonse {

    private String membername;

    private String img;

    private String memberstorepoint;
    private String memberposition;
    private int alltable;
    private int lefttable;

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMemberstorepoint() {
        return memberstorepoint;
    }

    public void setMemberstorepoint(String memberstorepoint) {
        this.memberstorepoint = memberstorepoint;
    }

    public String getMemberposition() {
        return memberposition;
    }

    public void setMemberposition(String memberposition) {
        this.memberposition = memberposition;
    }

    public int getAlltable() {
        return alltable;
    }

    public void setAlltable(int alltable) {
        this.alltable = alltable;
    }

    public int getLefttable() {
        return lefttable;
    }

    public void setLefttable(int lefttable) {
        this.lefttable = lefttable;
    }

    public RecommendResonse() {
    }

    public RecommendResonse(String membername, String img, String memberstorepoint, String memberposition, int alltable, int lefttable) {
        this.membername = membername;
        this.img = img;
        this.memberstorepoint = memberstorepoint;
        this.memberposition = memberposition;
        this.alltable = alltable;
        this.lefttable = lefttable;
    }
}
