package com.example.coca_server.Model;

public class LoginRequest {

    private String membername;
    private String memberpassword;

    public LoginRequest() {
    }

    public LoginRequest(String membername,String memberpassword){
        this.membername = membername;
        this.memberpassword = memberpassword;
    }
    public String getMembername(){
        return membername;
    }
    public void setMembername(String membername){
        this.membername = membername;
    }

    public String getMemberpassword(){
        return memberpassword;
    }

    public void setMemberpassword(String memberpassword){
        this.memberpassword = memberpassword;
    }
}
