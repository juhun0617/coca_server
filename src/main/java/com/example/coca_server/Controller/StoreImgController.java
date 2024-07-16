package com.example.coca_server.Controller;


import com.example.coca_server.Entity.Member;
import com.example.coca_server.Entity.StoreImg;
import com.example.coca_server.Model.ImgRequest;
import com.example.coca_server.Repository.MemberRepository;
import com.example.coca_server.Repository.StoreImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping("/imgapi")
public class StoreImgController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private StoreImgRepository storeImgRepository;

    @ResponseBody
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/storeimg", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(@RequestPart("membername") String membername,
                              @RequestPart("memberpassword") String memberpassword,
                              @RequestPart("img") MultipartFile img) throws IOException {

        String storedPassword = memberRepository.findByMembername(membername).get().getMemberpassword();

        if (storedPassword.equals(memberpassword)) {
            StoreImg storeImg = new StoreImg();
            storeImg.setMembername(membername);
            storeImg.setImg(img.getBytes());
            storeImgRepository.save(storeImg);
            return "success";
        } else {
            return "error";
        }
    }
}
