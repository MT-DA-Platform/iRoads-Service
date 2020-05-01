package com.codemo.iroads.Repository;

import com.codemo.iroads.Domain.DataItem;
import com.codemo.iroads.Domain.JourneyIDNamePair;
import com.codemo.iroads.Domain.crowdSourcing.LocationData;
import com.codemo.iroads.Util.IConstants;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "LocationData",viewName = "all")
public interface LocationDataRepository extends CouchbaseRepository<LocationData,String> {

   @Query("#{#n1ql.selectEntity} where dataType = 'crowd_location' and any v in locations satisfies v.latitude <$2+"+( IConstants.LatitudeOffSet) +" and v.latitude>$2-"+( IConstants.LatitudeOffSet) +" and v.longitude <$1+"+( IConstants.LongitudeOffSet) +" and v.longitude>$1-"+( IConstants.LongitudeOffSet) +" end")
   List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude);

    @Query("#{#n1ql.selectEntity} where dataType = 'crowd_location' and any v in locations satisfies v.latitude <$2+"+( IConstants.LatitudeOffSet) +" and v.latitude>$2-"+( IConstants.LatitudeOffSet) +" and v.longitude <$1+"+( IConstants.LongitudeOffSet) +" and v.longitude>$1-"+( IConstants.LongitudeOffSet) +"and v.timestamp>$3 and v.timestamp<$4 "+" end")
   List<LocationData> getCrowdLocationDataWhenLocationGiven(double longitude,double latitude,Long time1,Long time2);

    @Query("#{#n1ql.selectEntity} where dataType = 'crowd_location' and any v in locations satisfies v.timestamp>$1 and v.timestamp<$2 "+" end")
    List<LocationData> getCrowdLocationDataWhenLocationGiven(Long time1,Long time2);

    @Query("#{#n1ql.selectEntity} where dataType = 'crowd_location' and userID =$3 and any v in locations satisfies v.timestamp>$1 and v.timestamp<$2 "+" end")
    List<LocationData> getCrowdLocationDataWhenLocationGiven(Long time1,Long time2,String userID);

    @Query("#{#n1ql.selectEntity} where dataType = 'crowd_location' and userID =$3 and any v in locations satisfies v.latitude <$2+"+( IConstants.LatitudeOffSet) +" and v.latitude>$2-"+( IConstants.LatitudeOffSet) +" and v.longitude <$1+"+( IConstants.LongitudeOffSet) +" and v.longitude>$1-"+( IConstants.LongitudeOffSet) +" end")
    List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude,String userID);

    @Query("#{#n1ql.selectEntity} where dataType = 'crowd_location' and userID =$5 and any v in locations satisfies v.latitude <$2+"+( IConstants.LatitudeOffSet) +" and v.latitude>$2-"+( IConstants.LatitudeOffSet) +" and v.longitude <$1+"+( IConstants.LongitudeOffSet) +" and v.longitude>$1-"+( IConstants.LongitudeOffSet) +"and v.timestamp>$3 and v.timestamp<$4 "+" end")
    List<LocationData> getCrowdLocationDataWhenLocationGiven(Double longitude,Double latitude,Long time1, Long time2,String userID);


}
