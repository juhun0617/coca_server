package com.example.coca_server.Model;

public class TableStatusRequest {

    private String membername;
    private String floor;
    private int tablenum;


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

    public int getTablenum() {
        return tablenum;
    }

    public void setTablenum(int tablenum) {
        this.tablenum = tablenum;
    }


    public TableStatusRequest() {
    }

    public TableStatusRequest(String membername, String floor, int tablenum) {
        this.membername = membername;
        this.floor = floor;
        this.tablenum = tablenum;
    }
}
