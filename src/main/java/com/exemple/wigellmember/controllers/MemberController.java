package com.exemple.wigellmember.controllers;


import com.exemple.wigellmember.entities.Member;
import com.exemple.wigellmember.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.fetchAllMembers());
    }
    @GetMapping ("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PostMapping("/addmember")
    public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.addNewMember(member));
    }

    @PutMapping("/updatemember/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable int memberId, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(memberId, member));
    }

    @DeleteMapping("/deletemember/{memberId}")
    public ResponseEntity<String> deleteMemberById(@PathVariable int memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("Member with id " + memberId + " deleted successfully");
    }




}


