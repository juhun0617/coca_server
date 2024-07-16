package com.example.coca_server.Controller;


import com.example.coca_server.Entity.MemberState;
import com.example.coca_server.Model.MemberConfigRequest;
import com.example.coca_server.Repository.MemberStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/memberstateapi")
public class MemberStateController {

    @Autowired
    private MemberStateRepository memberStateRepository;

    @ResponseBody
    @PostMapping("/getstatus")
    public Boolean sendStatus(@RequestBody MemberConfigRequest request){
        String membername = request.getMembername();

        Optional<MemberState> stateOptional = memberStateRepository.findByMembername(membername);
        MemberState memberState = stateOptional.get();
        return memberState.isMemberstate();
    }

    @ResponseBody
    @PostMapping("/setstatus")
    public String setStatus(@RequestBody MemberState request){
        String membername = request.getMembername();

        Optional<MemberState> stateOptional = memberStateRepository.findByMembername(membername);
        MemberState memberState = stateOptional.get();
        memberState.setMemberstate(request.isMemberstate());
        memberStateRepository.save(memberState);

        return "Success";
    }

}
