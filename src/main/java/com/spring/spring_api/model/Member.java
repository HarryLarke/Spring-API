package com.spring.spring_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Member")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String origin; 
    private String stationedAt; //later a connecting value - turning into ID 
    private String legion; //Will be a connecting sql value leading to other groups with more info -- turned into ID 
    private String firstName;    
    private String lastName;
    private String rank; //Maybe convert to enum

    public Member() {

    }

    public Member(String origin, String stationedAt, String legion, 
    String firstName, String lastName, String rank){
        this.origin = origin;
        this.stationedAt = stationedAt;
        this.legion = legion;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*GETTERS*/
    public Integer getId(){
        return id;
    }
    public String getOrigin() {
        return origin;
    }
    public String getStationedAt() {
        return stationedAt;
    }
    public String getLegion() {
        return legion;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String rank() {
        return rank;
    }

    /*SETTERS*/
    public void setOrigin(String origin){
        this.origin = origin;
    }
    public void setStationedAt(String stationedAt) {
        this.stationedAt = stationedAt;
    }
    public void setLegion(String legion){
        this.legion = legion;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    /*CUSTOM METHODS*/
    public boolean isEmpty(Member member){
       if(!member.getOrigin().isEmpty()
       ){
        return true;
       }
       return false;
    }


    }
