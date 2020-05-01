package com.codemo.iroads.Repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.couchbase.client.java.document.json.JsonObject;


@Repository
public class CrowdSourceNonEntityRepository extends AbstractN1qlRunner{

    public String getAllCrowdUsers(){
        String query = "select distinct(userID) from iroads where dataType = 'crowd_location'";
        return getJsonArray(query).toString();
    }

    public int getCrowdUserCount(){
        String query = "select count(distinct(userID)) as count from iroads where dataType = 'crowd_location'";
        return execQuery(query).getInt("count");
    }

    public String getCrowdUsersWhen(Long startTime, Long endTime){
        String query ="select distinct(userID) from iroads  where dataType = 'crowd_location' and any v in locations satisfies v.timestamp>"+startTime+" and v.timestamp<"+endTime+" end";
        return getJsonArray(query).toString();
    }
}
