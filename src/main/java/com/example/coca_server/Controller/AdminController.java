package com.example.coca_server.Controller;


import com.example.coca_server.Entity.Member;
import com.example.coca_server.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/admin/members")
    public String showMemberList(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "admin/member-list";
    }

    @GetMapping("/admin/members/create")
    public String createMember(Model model) {
        model.addAttribute("member", new Member(0, "", ""));
        return "admin/member-form";
    }


    @PostMapping("/admin/members/create")
    public String createMember(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/admin/members";
    }

    @GetMapping("/admin/members/edit")
    public String showEditMemberForm(@RequestParam("id") int id, Model model) {
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "admin/member-form";
    }

    @PostMapping("/admin/members/edit")
    public String updateMember(@ModelAttribute Member member) {
        if (member.getMemberid() == 0) {
            throw new IllegalArgumentException("memberid cannot be null");
        }
        memberRepository.save(member);
        return "redirect:/admin/members";
    }

    @GetMapping("/admin/members/delete")
    public String deleteMember(@RequestParam("id") int id) {
        memberRepository.deleteById(id);
        return "redirect:/admin/members";
    }
}
