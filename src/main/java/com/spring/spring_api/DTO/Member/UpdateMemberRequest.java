package com.spring.spring_api.DTO.Member;

public record UpdateMemberRequest(
    String origin,
    String stationedAt,
    String legion,
    String firstName,
    String lastName,
    String rank
) {
} 
