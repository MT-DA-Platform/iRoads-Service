package com.codemo.iroads.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LatLonTag {
    private String dataType;
    private double lat;
    private double lon;
    private String tagType;
    private String journeyID;
    private long time;
}
