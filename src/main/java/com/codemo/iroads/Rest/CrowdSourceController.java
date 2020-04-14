package com.codemo.iroads.Rest;

import com.codemo.iroads.Domain.commonFormat.Location;
import com.codemo.iroads.Domain.crowdSourcing.LocationData;
import com.codemo.iroads.Repository.LocationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CrowdSourceController {

    @Autowired
    LocationDataRepository locationDataRepository;

    @PostMapping(path= "/saveCrowdLocation")
    public void saveCrowdLocation(@RequestBody LocationData locationData){

        locationDataRepository.saveAll(Stream.of(locationData).collect(Collectors.toList()));
    }

}
