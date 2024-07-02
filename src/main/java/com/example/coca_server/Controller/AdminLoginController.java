package com.example.coca_server.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @GetMapping("/adminlogin")
    public String showAdminLoginPage() {
        return "adminLogin";
    }

    @PostMapping("/adminlogin")
    public String processAdminLogin(String id, String pw, HttpServletRequest request) {
        if ("cocaadmin".equals(id) && "cocaadminpw".equals(pw)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminLogin", true);
            return "redirect:/admin/members";
        } else {
            return "redirect:/adminlogin";
        }
    }

    @GetMapping("/adminlogout")
    public String processAdminLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/adminlogin";
    }
}
