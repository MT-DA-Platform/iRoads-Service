package com.codemo.iroads.Service;

import com.codemo.iroads.Domain.crowdSourcing.LocationData;
import com.codemo.iroads.Repository.CrowdSourceNonEntityRepository;
import com.codemo.iroads.Repository.LocationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CrowdSourceServiceImpl implements CrowdSourceServiceI {

    @Autowired
    LocationDataRepository locationDataRepository;

    @Autowired
    CrowdSourceNonEntityRepository crowdSourceNonEntityRepository;

    public void save(LocationData locationData){
        locationDataRepository.saveAll(Stream.of(locationData).collect(Collectors.toList()));
    }

    public List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude, Double latitude){
        return locationDataRepository.getCrowdLocationDataWhenLocationGiven(longitude,latitude);
    }

    public List<LocationData> getCrowdLocationDataWhenLocationGiven(double longitude,double latitude,Long time1,Long time2){
        return locationDataRepository.getCrowdLocationDataWhenLocationGiven(longitude,latitude,time1,time2);
    }

   public List<LocationData> getCrowdLocationDataWhenLocationGiven(Long time1,Long time2){
        return locationDataRepository.getCrowdLocationDataWhenLocationGiven(time1,time2);
    }

   public List<LocationData> getCrowdLocationDataWhenLocationGiven(Long time1,Long time2,String userID){
        return locationDataRepository.getCrowdLocationDataWhenLocationGiven(time1,time2,userID);
    }

    public List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude,String userID){
        return locationDataRepository.getCrowdLocationDataWhenLocationGiven(longitude,latitude,userID);
    }

   public  List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude,Long time1, Long time2,String userID){
        return locationDataRepository.getCrowdLocationDataWhenLocationGiven(longitude,latitude,time1,time2,userID);
    }


    public String getAllCrowdUsers(){
       return crowdSourceNonEntityRepository.getAllCrowdUsers();
    }

    public int getCrowdUserCount(){
        return crowdSourceNonEntityRepository.getCrowdUserCount();
    }

    public String getCrowdUsersWhen(Long startTime, Long endTime){
        return crowdSourceNonEntityRepository.getCrowdUsersWhen(startTime,endTime);
    }
}
