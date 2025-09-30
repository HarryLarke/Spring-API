package com.spring.spring_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_api.model.Station;

public interface StationRepo extends JpaRepository<Station, Integer>{

}
