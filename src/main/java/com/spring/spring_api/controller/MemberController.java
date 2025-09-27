package com.spring.spring_api.controller;
import com.spring.spring_api.service.MemberService;

import jakarta.validation.Valid;

import com.spring.spring_api.DTO.AddMemberRequest;
import com.spring.spring_api.DTO.UpdateMemberRequest;
import com.spring.spring_api.model.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public ResponseEntity<List<Member>> getMembers(){
        List<Member> foundMembers = MemberService.getAll();
        return ResponseEntity.ok().body(foundMembers);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Member>> getMemberById(
        @PathVariable Integer id
    ) {
        Optional<Member> foundMember = MemberService.getById(id);
        return ResponseEntity.ok().body(foundMember);    
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMember(
        @PathVariable Integer id 
    ) {
        MemberService.deleteById(id);
        return ResponseEntity.ok().body("Member with ID: " + id + " has been deleted.");
    }

    @PostMapping
    public ResponseEntity<String> addMember(
        @RequestBody @Valid AddMemberRequest req
    ){
       MemberService.add(req);
       return ResponseEntity.created(null).body("Member has been added.");
    }   

    
    @PutMapping("{id}")
    public ResponseEntity<String> updateMember(
        @PathVariable Integer id, 
        @RequestBody UpdateMemberRequest req
    ){
        MemberService.update(id, req);
        return ResponseEntity.ok().body("Member with id: " + id + " has been updated.");
    } 

    //Later add other methods, such as get by legion etc. 

}
