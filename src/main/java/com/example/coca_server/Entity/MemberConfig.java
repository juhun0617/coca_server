package com.example.coca_server.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "memberConfig")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberConfig {
    @Id
    @Column(name = "memeber_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int memberid;

    @Column(name = "member_name",unique = true)
    private String membername;

    @Column(name = "member_spec")
    private String memberspec;

    @Column(name = "member_OpentimeHour")
    private String memberopentimehour;

    @Column(name = "member_OpentimeMin")
    private String memberopentimemin;

    @Column(name = "member_ClosedtimeHour")
    private String memberclosedtimehour;

    @Column(name = "member_ClosedtimeMin")
    private String memberclosedtimemin;

    @Column(name = "member_mobile")
    private String membermobile;

    @Column(name = "member_position")
    private String memberposition;

    @Column(name = "member_category")
    private String membercategory;

    public String getMembername() {
        return membername;
    }

    public String getMembermobile() {
        return membermobile;
    }

    public String getMemberspec() {
        return memberspec;
    }

    public String getMemberposition() {
        return memberposition;
    }

    public String getMemberclosedtimehour() {
        return memberclosedtimehour;
    }

    public String getMemberclosedtimemin() {
        return memberclosedtimemin;
    }

    public String getMemberopentimehour() {
        return memberopentimehour;
    }

    public String getMemberopentimemin() {
        return memberopentimemin;
    }



    public void setMembername(String membername) {
        this.membername = membername;
    }

    public void setMemberspec(String memberspec) {
        this.memberspec = memberspec;
    }

    public void setMembermobile(String membermobile) {
        this.membermobile = membermobile;
    }

    public void setMemberposition(String memberposition) {
        this.memberposition = memberposition;
    }

    public void setMemberopentimehour(String memberopentimehour) {
        this.memberopentimehour = memberopentimehour;
    }

    public void setMemberopentimemin(String memberopentimemin) {
        this.memberopentimemin = memberopentimemin;
    }

    public void setMemberclosedtimehour(String memberclosedtimehour) {
        this.memberclosedtimehour = memberclosedtimehour;
    }

    public void setMemberclosedtimemin(String memberclosedtimemin) {
        this.memberclosedtimemin = memberclosedtimemin;
    }

    public String getMembercategory() {
        return membercategory;
    }

    public void setMembercategory(String membercategory) {
        this.membercategory = membercategory;
    }

    public MemberConfig(){

    }

    public MemberConfig(@NonNull int memberid, String membername, String memberspec, String memberopentimehour, String memberopentimemin, String memberclosedtimehour, String memberclosedtimemin, String membermobile, String memberposition, String membercategory) {
        this.memberid = memberid;
        this.membername = membername;
        this.memberspec = memberspec;
        this.memberopentimehour = memberopentimehour;
        this.memberopentimemin = memberopentimemin;
        this.memberclosedtimehour = memberclosedtimehour;
        this.memberclosedtimemin = memberclosedtimemin;
        this.membermobile = membermobile;
        this.memberposition = memberposition;
        this.membercategory = membercategory;
    }
}
