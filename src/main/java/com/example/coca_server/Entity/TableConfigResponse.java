package com.example.coca_server.Entity;

import com.example.coca_server.Model.TableConfigModel;

import java.util.List;

public class TableConfigResponse {

    private String floor;
    private int displaysizex;
    private int displaysizey;

    private int alltable;
    private int lefttable;



    private List<TableConfigModel> tableConfigModels;


    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getDisplaysizex() {
        return displaysizex;
    }

    public void setDisplaysizex(int displaysizex) {
        this.displaysizex = displaysizex;
    }

    public int getDisplaysizey() {
        return displaysizey;
    }

    public void setDisplaysizey(int displaysizey) {
        this.displaysizey = displaysizey;
    }

    public List<TableConfigModel> getTableConfigModels() {
        return tableConfigModels;
    }

    public void setTableConfigModels(List<TableConfigModel> tableConfigModels) {
        this.tableConfigModels = tableConfigModels;
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

    public TableConfigResponse() {
    }
}
