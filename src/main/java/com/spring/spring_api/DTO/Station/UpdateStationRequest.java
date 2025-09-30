package com.spring.spring_api.DTO.Station;

public record UpdateStationRequest(
    int personelSize,
    double hazardStatus,
    String commander
) {
} 

