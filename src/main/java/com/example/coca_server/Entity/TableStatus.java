package com.example.coca_server.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tableStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TableStatus {
    @Id
    @Column(name = "table_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int tableid;

    @Column(name = "member_name")
    private String membername;

    @Column(name = "floor")
    private String floor;

    @Column(name = "table_num")
    private int tablenum;

    @Column(name = "isOn")
    private boolean ison;


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

    public boolean isIson() {
        return ison;
    }

    public void setIson(boolean ison) {
        this.ison = ison;
    }


    public TableStatus() {
    }

    public TableStatus(@NonNull int tableid, String membername,String floor ,int tablenum, boolean ison) {
        this.tableid = tableid;
        this.membername = membername;
        this.floor = floor;
        this.tablenum = tablenum;
        this.ison = ison;
    }
}
