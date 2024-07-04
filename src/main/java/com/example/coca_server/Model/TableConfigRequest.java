package com.example.coca_server.Model;

public class TableConfigRequest {

    private String membername;

    public TableConfigRequest(){

    }


    public TableConfigRequest(String membername){
        this.membername = membername;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }
}
