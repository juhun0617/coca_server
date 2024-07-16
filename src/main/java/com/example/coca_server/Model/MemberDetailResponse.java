package com.example.coca_server.Model;

import jakarta.persistence.Column;

public class MemberDetailResponse {

    private String img;
    private String membername;
    private String memberstorepoint;
    private String memberposition;
    private String memberopentimehour;

    private String memberopentimemin;

    private String memberclosedtimehour;

    private String memberclosedtimemin;

    private boolean memberstate;
    private String membermobile;
    private String memberspec;

    private int alltable;
    private int lefttable;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
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

    public String getMemberopentimehour() {
        return memberopentimehour;
    }

    public void setMemberopentimehour(String memberopentimehour) {
        this.memberopentimehour = memberopentimehour;
    }

    public String getMemberopentimemin() {
        return memberopentimemin;
    }

    public void setMemberopentimemin(String memberopentimemin) {
        this.memberopentimemin = memberopentimemin;
    }

    public String getMemberclosedtimehour() {
        return memberclosedtimehour;
    }

    public void setMemberclosedtimehour(String memberclosedtimehour) {
        this.memberclosedtimehour = memberclosedtimehour;
    }

    public String getMemberclosedtimemin() {
        return memberclosedtimemin;
    }

    public void setMemberclosedtimemin(String memberclosedtimemin) {
        this.memberclosedtimemin = memberclosedtimemin;
    }

    public boolean isMemberstate() {
        return memberstate;
    }

    public void setMemberstate(boolean memberstate) {
        this.memberstate = memberstate;
    }

    public String getMembermobile() {
        return membermobile;
    }

    public void setMembermobile(String membermobile) {
        this.membermobile = membermobile;
    }

    public String getMemberspec() {
        return memberspec;
    }

    public void setMemberspec(String memberspec) {
        this.memberspec = memberspec;
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

    public MemberDetailResponse() {
    }

    public MemberDetailResponse(String img, String membername, String memberstorepoint, String memberposition, String memberopentimehour, String memberopentimemin, String memberclosedtimehour, String memberclosedtimemin, boolean memberstate, String membermobile, String memberspec, int alltable, int lefttable) {
        this.img = img;
        this.membername = membername;
        this.memberstorepoint = memberstorepoint;
        this.memberposition = memberposition;
        this.memberopentimehour = memberopentimehour;
        this.memberopentimemin = memberopentimemin;
        this.memberclosedtimehour = memberclosedtimehour;
        this.memberclosedtimemin = memberclosedtimemin;
        this.memberstate = memberstate;
        this.membermobile = membermobile;
        this.memberspec = memberspec;
        this.alltable = alltable;
        this.lefttable = lefttable;
    }
}
