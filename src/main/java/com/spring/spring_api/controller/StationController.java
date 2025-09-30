package com.spring.spring_api.controller;

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

import com.spring.spring_api.DTO.Station.AddStationRequest;
import com.spring.spring_api.DTO.Station.UpdateStationRequest;
import com.spring.spring_api.model.Station;
import com.spring.spring_api.service.StationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/stations")
public class StationController {
    
    @GetMapping
    public ResponseEntity <List<Station>> getStations(){
        List<Station> foundStations = StationService.getAll();
        return ResponseEntity.ok().body(foundStations);
    }

    @GetMapping("{id}")
    public ResponseEntity <Optional<Station>> getStationById(
        @PathVariable Integer id
    ){
        Optional <Station> foundStation = StationService.getById(id);
        return ResponseEntity.ok().body(foundStation);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteStationById(
        @PathVariable Integer id
    ) {
        StationService.deleteById(id);
        return ResponseEntity.ok().body("Station with id: " + id + " has been deleted.");
    }

    @PostMapping
    public ResponseEntity <String> addStation(
        @RequestBody @Valid AddStationRequest req
    ){
        StationService.add(req);
        return ResponseEntity.created(null).body("New Station Created.");
    }

    @PutMapping("{id}")
    public ResponseEntity <String> updateStation(
        @RequestBody @Valid UpdateStationRequest req,
        @PathVariable Integer id
    ){
        StationService.update(req, id);
        return ResponseEntity.ok().body("Station with id: " + id + " has been updated.");
    }
}
