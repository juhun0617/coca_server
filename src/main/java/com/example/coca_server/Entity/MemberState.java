package com.example.coca_server.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_state")
public class MemberState {


    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int memberid;

    @Column(name = "member_name")
    private String membername;

    @Column(name = "memberstate")
    private boolean memberstate;

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public boolean isMemberstate() {
        return memberstate;
    }

    public void setMemberstate(boolean memberstate) {
        this.memberstate = memberstate;
    }


    public MemberState() {
    }

    public MemberState(@NonNull int memberid, String membername, boolean memberstate) {
        this.memberid = memberid;
        this.membername = membername;
        this.memberstate = memberstate;
    }
}
