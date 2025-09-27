package com.spring.spring_api.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.spring.spring_api.SpringApiApplication;
import com.spring.spring_api.DTO.AddMemberRequest;
import com.spring.spring_api.DTO.UpdateMemberRequest;
import com.spring.spring_api.model.Member;
import com.spring.spring_api.repository.MemberRepo;

@Service
public class MemberService {
    
    private static MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo, SpringApiApplication springApiApplication) {
        MemberService.memberRepo = memberRepo;
    }

    public static List<Member> getAll(){
         return memberRepo.findAll();
    }

    public static Optional<Member> getById(Integer id){
        Optional<Member> foundMember = memberRepo.findById(id);
        if(foundMember.isEmpty()){
            throw new RuntimeException("Not found");//Will make custom exception later.
        }
        return foundMember;
    } 

    public static void deleteById(Integer id){
        memberRepo.deleteById(id);
    }

    public static void add(AddMemberRequest req){
        
        Member newMember = new Member(
            req.origin(), req.stationedAt(), req.legion(), 
            req.firstName(), req.lastName(), req.rank());

        memberRepo.save(newMember); //Don't know if this is the cleanest method or not?
    }

   /*  public static void update(String id, UpdateMemberRequest req){
         //Probably require seperate class either/or DTO?
        Optional<Member> foundMember = getById(id);
        if(foundMember.isEmpty()){
            throw new RuntimeException("Member not found");
        } 
        updateStringIfPresent(req.origin(), foundMember.setOrigin());
        
    }

    private void updateStringIfPresent(String newString, Consumer<String> setter){
        Optional.ofNullable(newString)
            .filter(string -> !string.isBlank())
            .ifPresent(setter);
    } */


}


