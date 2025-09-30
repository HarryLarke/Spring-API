package com.spring.spring_api.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.spring.spring_api.SpringApiApplication;
import com.spring.spring_api.DTO.Station.AddStationRequest;
import com.spring.spring_api.DTO.Station.UpdateStationRequest;
import com.spring.spring_api.model.Station;
import com.spring.spring_api.repository.StationRepo;

@Service
public class StationService {

    private static StationRepo stationRepo;

    public StationService(StationRepo stationRepo, SpringApiApplication springApiApplication){
        StationService.stationRepo = stationRepo;
    }

    public static List<Station> getAll(){
        return stationRepo.findAll();
    }

    public static Optional<Station> getById(Integer id){
        Optional<Station> foundStation = stationRepo.findById(id);
        if(foundStation.isEmpty()){
            throw new RuntimeException("Station not found"); //Will need custom notFound!
        }
        return foundStation;
    }

    public static void deleteById(Integer id){
        if(!stationRepo.existsById(id)){
            throw new RuntimeException("Id not found.");
        }
        stationRepo.deleteById(id);
    }

    public static void add(AddStationRequest req){
        
        Station newStation = new Station(
            req.name(), req.planet(), req.coordinates(), 
            req.personelSize(), req.hazardStatus(), req.commander());

        stationRepo.save(newStation);
    }

    public static void update(UpdateStationRequest req, Integer id){
        Optional<Station> foundStationOpt = stationRepo.findById(id);
        if(foundStationOpt.isEmpty()){
            throw new RuntimeException("Station not found.");
        }
        Station foundStation = foundStationOpt.get();

        foundStation.setPeronelSize(req.personelSize());
        foundStation.setHazardStatus(req.hazardStatus());
        updateStringIfPresent(req.commander(), foundStation::setCommander);

        stationRepo.save(foundStation);
    }

     private static void updateStringIfPresent(String newValue, Consumer<String> setter){
        Optional.ofNullable(newValue)
            .filter(string -> !string.isBlank())
            .ifPresent(setter); //Maybe move to utils later?
    } 

    //Worth producing update if notNull



}
