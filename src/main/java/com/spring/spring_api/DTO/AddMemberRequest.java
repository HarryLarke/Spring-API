package com.spring.spring_api.DTO;

import jakarta.validation.constraints.NotEmpty;

public record AddMemberRequest(
    @NotEmpty(message = "Plant or System of origin required") String origin,
    @NotEmpty(message = "Location of station Required") String stationedAt,
    @NotEmpty(message = "Name of legion is required") String legion,
    String firstName,
    String lastName,
    String rank
) {
} 