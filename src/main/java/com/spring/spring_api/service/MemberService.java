package com.spring.spring_api.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.spring.spring_api.SpringApiApplication;
import com.spring.spring_api.DTO.AddMemberRequest;
import com.spring.spring_api.DTO.UpdateMemberRequest;
import com.spring.spring_api.exception.MemberNotFoundException;
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
            throw new MemberNotFoundException("Member with ID: " + id + " is not found.");
        }
        return foundMember;
    } 

    public static void deleteById(Integer id){
        if(!memberRepo.existsById(id)){
            throw new MemberNotFoundException("Member with id: " + id + " is not found. Cannot be deleted.");
        }
        memberRepo.deleteById(id); //Will need an exists check here!
    }

    public static void add(AddMemberRequest req){
        
        Member newMember = new Member(
            req.origin(), req.stationedAt(), req.legion(), 
            req.firstName(), req.lastName(), req.rank());

        memberRepo.save(newMember); //Don't know if this is the cleanest method or not?
    }

    public static void update(Integer id, UpdateMemberRequest req){
         //Probably require seperate class either/or DTO?
        Optional<Member> foundMemberOpt = memberRepo.findById(id);
        if(foundMemberOpt.isEmpty()){
            throw new MemberNotFoundException("Member with ID: " + id + " is not found. Cannot be updated.");
        } 
        Member foundMember = foundMemberOpt.get();
        updateStringIfPresent(req.origin(), foundMember::setOrigin);
        updateStringIfPresent(req.stationedAt(), foundMember::setStationedAt);
        updateStringIfPresent(req.legion(), foundMember::setLegion);
        updateStringIfPresent(req.firstName(), foundMember::setFirstName);
        updateStringIfPresent(req.lastName(), foundMember::setLastName);
        updateStringIfPresent(req.rank(), foundMember::setRank);

        memberRepo.save(foundMember);
 
    }

    private static void updateStringIfPresent(String newValue, Consumer<String> setter){
        Optional.ofNullable(newValue)
            .filter(string -> !string.isBlank())
            .ifPresent(setter);
    } 


}


