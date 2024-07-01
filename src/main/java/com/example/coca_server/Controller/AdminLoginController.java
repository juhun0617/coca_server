package com.example.coca_server.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminLoginController {

    @GetMapping("/adminlogin")
    public String showAdminLoginPage(){
        return "adminLogin";
    }

    @PostMapping("/adminlogin")
    public String processAdminLogin(String id,String pw){
        if (id.equals("cocaadmin") && pw.equals("cocaadminpw")){
            return "redirect:/admin/members";
        } else
            return "redirect:adminLogin";
    }

}
