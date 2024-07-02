package com.example.coca_server.Model;

public class MemberConfigRequest {

    private String membername;

    public MemberConfigRequest() {

    }

    public MemberConfigRequest(String membername){
        this.membername = membername;
    }

    public String getMembername(){
        return membername;
    }
    public void setMembername(String membername){
        this.membername = membername;
    }
}
