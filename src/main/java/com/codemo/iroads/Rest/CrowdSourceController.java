package com.codemo.iroads.Rest;

import com.codemo.iroads.Domain.crowdSourcing.LocationData;
import com.codemo.iroads.Service.CrowdSourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrowdSourceController {

    @Autowired
    CrowdSourceServiceImpl crowdSourceService;

    @PostMapping(path= "/saveCrowdLocation")
    public void saveCrowdLocation(@RequestBody LocationData locationData){
       crowdSourceService.save(locationData);
    }

    @RequestMapping("/getCrowdLocationData")
    public List<LocationData> getCrowdLocationData(@RequestParam(value ="longitude" ,required = false) Double longitude, @RequestParam(value ="latitude", required = false) Double latitude,@RequestParam(value ="startTime", required = false) Long startTime,@RequestParam(value ="endTime",required = false) Long endTime, @RequestParam(value="userID",required = false) String userID) {
      return getResultForRequest(longitude,latitude,startTime,endTime,userID);
    }

    @RequestMapping("/getAllCrowdUsers")
    public String getAllCrowdUsers(){
        return crowdSourceService.getAllCrowdUsers();
    }

    @RequestMapping("/getCrowdUsersCount")
    public int getCrowdUserCount(){
        return crowdSourceService.getCrowdUserCount();
    }

    @RequestMapping("/getCrowdUsersWhen")
    public String getCrowdUsersWhen(Long startTime, Long endTime){
        return  crowdSourceService.getCrowdUsersWhen(startTime,endTime);
    }


    public List<LocationData> getResultForRequest(Double longitude, Double latitude,Long startTime,Long endTime, String userID ){
        if (longitude !=null && latitude !=null && startTime == null && endTime == null && userID == null) {
            return crowdSourceService.getCrowdLocationDataWhenLocationGiven(longitude, latitude);
        }
        else if (longitude != null && latitude != null &&  startTime != null & endTime != null && userID == null) {
            return crowdSourceService.getCrowdLocationDataWhenLocationGiven(longitude, latitude, startTime, endTime);
        }
        else if(longitude == null && latitude == null && startTime != null && endTime != null && userID == null){
            return crowdSourceService.getCrowdLocationDataWhenLocationGiven(startTime,endTime);
        }
        else if(longitude == null && latitude == null && startTime != null && endTime != null && userID != null){
            return crowdSourceService.getCrowdLocationDataWhenLocationGiven(startTime,endTime,userID);
        }
        else if (longitude != null && latitude != null && startTime == null && endTime == null && userID != null){
            return crowdSourceService.getCrowdLocationDataWhenLocationGiven(longitude,latitude,userID);
        }

        else if (longitude != null && latitude != null &&  startTime != null & endTime != null && userID != null){
            return crowdSourceService.getCrowdLocationDataWhenLocationGiven(longitude,latitude,startTime,endTime,userID);
        }
         return null;
    }




}
