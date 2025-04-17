package com.exemple.wigellmember.services;


import com.exemple.wigellmember.entities.Address;
import com.exemple.wigellmember.entities.Member;
import com.exemple.wigellmember.exceptions.ResourceNotFoundException;
import com.exemple.wigellmember.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberServiceInterface {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private com.exemple.wigellmember.repository.AddressRepository addressRepository;

    @Override
    public List<Member> fetchAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id){
        return memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "id", id));
    }


    @Override
    public Member addNewMember(Member member) {
        int addressId = member.getAddress().getId();

        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException("Address", "id", addressId));

        member.setAddress(address);

        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(int id, Member member) {
        memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "id", id));

        int addressId = member.getAddress().getId();

        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException("Address", "id", addressId));
        member.setAddress(address);

        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "id", id));
        memberRepository.deleteById(id);

    }
}
