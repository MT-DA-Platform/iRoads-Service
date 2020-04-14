package com.codemo.iroads.Repository;

import com.codemo.iroads.Domain.crowdSourcing.LocationData;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "LocationData",viewName = "all")
public interface LocationDataRepository extends CouchbaseRepository<LocationData,String> {

}
