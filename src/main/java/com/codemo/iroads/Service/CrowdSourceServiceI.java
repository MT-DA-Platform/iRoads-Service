package com.codemo.iroads.Service;

import com.codemo.iroads.Domain.crowdSourcing.LocationData;

import java.util.List;

public interface CrowdSourceServiceI {
    public void save(LocationData locationData);
    public List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude, Double latitude);
    public List<LocationData> getCrowdLocationDataWhenLocationGiven(double longitude,double latitude,Long time1,Long time2);
    public List<LocationData> getCrowdLocationDataWhenLocationGiven(Long time1,Long time2);
    public List<LocationData> getCrowdLocationDataWhenLocationGiven(Long time1,Long time2,String userID);
    public List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude,String userID);
    public  List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude,Long time1, Long time2,String userID);
    public String getAllCrowdUsers();
    public int getCrowdUserCount();
    public String getCrowdUsersWhen(Long startTime, Long endTime);



}
