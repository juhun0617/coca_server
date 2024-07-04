package com.example.coca_server.Controller;

import com.example.coca_server.Entity.Member;
import com.example.coca_server.Entity.MemberConfig;
import com.example.coca_server.Repository.MemberConfigRepository;
import com.example.coca_server.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConfigRepository memberConfigRepository;

    private boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Boolean loggedIn = (Boolean) session.getAttribute("adminLogin");
        return loggedIn != null && loggedIn;
    }

    @GetMapping("/admin/members")
    public String showMemberList(HttpServletRequest request, Model model) {
        if (!isAdminLoggedIn(request)) {
            return "redirect:/adminlogin";
        }
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "admin/member-list";
    }

    @GetMapping("/admin/members/create")
    public String createMember(HttpServletRequest request, Model model) {
        if (!isAdminLoggedIn(request)) {
            return "redirect:/adminlogin";
        }
        model.addAttribute("member", new Member(0, "", ""));
        return "admin/member-form";
    }

    @PostMapping("/admin/members/create")
    public String createMember(HttpServletRequest request, @ModelAttribute Member member) {
        if (!isAdminLoggedIn(request)) {
            return "redirect:/adminlogin";
        }
        memberRepository.save(member);
        MemberConfig memberConfig = new MemberConfig(0,member.getMembername(),"","0","0","0","0","","");
        memberConfigRepository.save(memberConfig);
        return "redirect:/admin/members";
    }

    @GetMapping("/admin/members/edit")
    public String showEditMemberForm(HttpServletRequest request, @RequestParam("id") int id, Model model) {
        if (!isAdminLoggedIn(request)) {
            return "redirect:/adminlogin";
        }
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "admin/member-form";
    }

    @PostMapping("/admin/members/edit")
    public String updateMember(HttpServletRequest request, @ModelAttribute Member member) {
        if (!isAdminLoggedIn(request)) {
            return "redirect:/adminlogin";
        }
        if (member.getMemberid() == 0) {
            throw new IllegalArgumentException("memberid cannot be null");
        }
        memberRepository.save(member);
        return "redirect:/admin/members";
    }

    @GetMapping("/admin/members/delete")
    public String deleteMember(HttpServletRequest request, @RequestParam("id") int id) {
        if (!isAdminLoggedIn(request)) {
            return "redirect:/adminlogin";
        }
        memberRepository.deleteById(id);
        return "redirect:/admin/members";
    }
}
