package com.example.coca_server.Controller;


import com.example.coca_server.Entity.Member;
import com.example.coca_server.Model.LoginRequest;
import com.example.coca_server.Model.LoginResponse;
import com.example.coca_server.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String membername = request.getMembername();
        String memberpassword = request.getMemberpassword();

        Optional<Member> userOptional = memberRepository.findByMembername(membername);
        if (userOptional.isPresent()) {
            Member member = userOptional.get();
            if (member.getMemberpassword().equals(memberpassword)) {
                return ResponseEntity.ok(new LoginResponse(true,"Login success"));
            } else {
                return ResponseEntity.ok(new LoginResponse(false, "Incorrect password"));
            }

        } else {
            return ResponseEntity.ok(new LoginResponse(false, "User not found"));
        }
    }
}
