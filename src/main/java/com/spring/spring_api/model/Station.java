package com.spring.spring_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="station")
public class Station {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name; //Maybe make this the locating variable ,or ID and puit this on the Member table?
    String planet; //another db link here?
    float coordinates;
    int personelSize; 
    double hazardStatus;
    String commander; 

    public Station(){

    }

    public Station(
        String name, String planet, float coordinates, int personelSize, double hazardStatus, String commander
    ){
        this.name = name;
        this.planet = planet;
        this.coordinates = coordinates;
        this.personelSize = personelSize;
        this.hazardStatus = hazardStatus;
        this.commander = commander;
    }

    /*GETTERS*/

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPlanet(){
        return planet;
    }
    public float getCoordinates(){
        return coordinates;
    }
    public int getPersonelSize(){
        return personelSize;
    }
    public double getHazardStatus(){
        return hazardStatus;
    }
    public String getCommander(){
        return commander;
    }

    /*SETTERS*/
    public void setName(String name){
        this.name = name;
    }
    public void setPlanet(String planet){
        this.planet = planet;
    }
    public void setCoordinates(float coordinates){
        this.coordinates = coordinates;
    }
    public void setPeronelSize(int personelSize){
        this.personelSize = personelSize;
    }
    public void setHazardStatus(double hazardStatus){
        this.hazardStatus = hazardStatus;
    }
    public void setCommander(String commander){
        this.commander = commander;
    }


    /*CUSTOM METHODS*/
    public boolean isEmpty(Station station){
        if(station.getId() == null){
            return true;
        }
        return false;
    } //Don't know if this method works????!!!!

}
