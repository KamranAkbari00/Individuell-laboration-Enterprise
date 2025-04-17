package com.exemple.wigellmember.services;

import com.exemple.wigellmember.entities.Member;

import java.util.List;

public interface MemberServiceInterface {
    List<Member> fetchAllMembers();

    Member getMemberById(int id);

    Member addNewMember(Member member);

    Member updateMember(int id, Member member);

    void deleteMember(int id);


}
