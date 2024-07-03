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

}
