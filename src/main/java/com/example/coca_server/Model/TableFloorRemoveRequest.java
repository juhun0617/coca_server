package com.example.coca_server.Model;

public class TableFloorRemoveRequest {

    private String membername;
    private String floor;

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public TableFloorRemoveRequest(){

    }

    public TableFloorRemoveRequest(String membername,String floor){
        this.membername = membername;
        this.floor = floor;
    }
}
