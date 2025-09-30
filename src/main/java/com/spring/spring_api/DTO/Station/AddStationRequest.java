package com.spring.spring_api.DTO.Station;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddStationRequest(
    @NotEmpty(message = "Station name is required.") String name,
    @NotEmpty(message = "Name of planet located required.") String planet,
    @NotNull(message = "Galactic coordinates are rquired") float coordinates,
    int personelSize,
    @NotNull(message = "Hazard Status required.") double hazardStatus,
    String commander
) {
    
}
 