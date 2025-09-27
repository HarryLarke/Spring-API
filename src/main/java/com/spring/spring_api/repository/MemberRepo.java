package com.spring.spring_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_api.model.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {

} 
