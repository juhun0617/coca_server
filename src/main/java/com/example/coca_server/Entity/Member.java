package com.example.coca_server.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@ToString(exclude = "memberPassword")
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int memberid;

    @Column(name = "member_name", unique = true)
    private String membername;

    @Column(name = "member_password")
    private String memberpassword;

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMemberpassword() {
        return memberpassword;
    }

    public void setMemberpassword(String memberpassword) {
        this.memberpassword = memberpassword;
    }

    public Member(){

    }

    @Builder
    public Member(int memberid, String membername, String memberpassword) {
        this.memberid = memberid;
        this.membername = membername;
        this.memberpassword = memberpassword;
    }
}
