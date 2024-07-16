package com.example.coca_server.Entity;


import jakarta.persistence.*;
import lombok.NonNull;

@Entity
@Table(name = "store_img")
public class StoreImg {

    @Id
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int imgid;

    @Column(name = "member_name")
    private String membername;

    @Lob // Large Object Annotation
    @Column(name = "img", columnDefinition = "LONGBLOB")//LONGBLOB
    private byte[] img;


    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public StoreImg() {
    }

    public StoreImg(@NonNull int imgid, String membername, byte[] img) {
        this.imgid = imgid;
        this.membername = membername;
        this.img = img;
    }
}


