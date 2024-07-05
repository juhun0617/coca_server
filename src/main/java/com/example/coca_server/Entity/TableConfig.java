package com.example.coca_server.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tableConfig")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TableConfig {
    @Id
    @Column(name = "table_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int tableid;

    @Column(name = "member_name")
    private String membername;

    @Column(name = "px")
    private int px;

    @Column(name = "py")
    private int py;

    @Column(name = "lx")
    private int lx;

    @Column(name = "ly")
    private int ly;

    @Column(name = "table_num")
    private int tablenum;

    @Column(name = "peoples")
    private int peoples;

    @Column(name = "floor")
    private String floor;


    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getLx() {
        return lx;
    }

    public void setLx(int lx) {
        this.lx = lx;
    }

    public int getLy() {
        return ly;
    }

    public void setLy(int ly) {
        this.ly = ly;
    }

    public int getTablenum() {
        return tablenum;
    }

    public void setTablenum(int tablenum) {
        this.tablenum = tablenum;
    }

    public int getPeoples() {
        return peoples;
    }


    public void setPeoples(int peoples) {
        this.peoples = peoples;
    }


    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public TableConfig(){

    }

    public TableConfig(int tableid,String membername, int px, int py, int lx, int ly, int tablenum, int peoples,String floor){
        this.tableid = tableid;
        this.membername = membername;
        this.px = px;
        this.py = py;
        this.lx = lx;
        this.ly = ly;
        this.tablenum = tablenum;
        this.peoples = peoples;
        this.floor = floor;
    }
}
