package com.exemple.wigellmember.controllers;

import org.springframework.ui.Model;
import com.exemple.wigellmember.entities.Member;
import com.exemple.wigellmember.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MemberThymeleafController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/deletemember")
    public String showDeleteMemberPage(Model model) {
        List<Member> members = memberService.fetchAllMembers();
        model.addAttribute("members", members);
        return "deletemember";
    }

    @PostMapping("/deletememberbyid")
    public String deleteMemberById(@RequestParam("id") int id) {
        memberService.deleteMember(id);
        return "redirect:/admin/deletemember";
    }

}
