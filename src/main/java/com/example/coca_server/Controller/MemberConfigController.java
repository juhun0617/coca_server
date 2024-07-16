package com.example.coca_server.Controller;


import com.example.coca_server.Entity.MemberConfig;
import com.example.coca_server.Model.MemberConfigRequest;
import com.example.coca_server.Repository.MemberConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/configapi")
public class MemberConfigController {
    @Autowired
    private MemberConfigRepository memberConfigRepository;


    @PostMapping("/memberconfig")
    public ResponseEntity<MemberConfig> sendMemberConfig(@RequestBody MemberConfigRequest request){
        String membername = request.getMembername();

        Optional<MemberConfig> userOptional = memberConfigRepository.findByMembername(membername);
        MemberConfig memberConfig = userOptional.get();
        return ResponseEntity.ok(memberConfig);

    }

    @PutMapping("/memberconfig")
    public void writeMemberConfig(@RequestBody MemberConfig request){
        System.out.println(request.toString());
         Optional<MemberConfig> userOptional = memberConfigRepository.findByMembername(request.getMembername());
         MemberConfig memberConfig = userOptional.get();
         memberConfig.setMembermobile(request.getMembermobile());
         memberConfig.setMemberspec(request.getMemberspec());
         memberConfig.setMemberposition(request.getMemberposition());
         memberConfig.setMemberopentimehour(request.getMemberopentimehour());
         memberConfig.setMemberopentimemin(request.getMemberopentimemin());
         memberConfig.setMemberclosedtimehour(request.getMemberclosedtimehour());
         memberConfig.setMemberclosedtimemin(request.getMemberclosedtimemin());
         memberConfig.setMembercategory(request.getMembercategory());
         System.out.println(request.getMembercategory()+"--");

         memberConfigRepository.save(memberConfig);
    }

}
