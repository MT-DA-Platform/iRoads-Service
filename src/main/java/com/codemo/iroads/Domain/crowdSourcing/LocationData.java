package com.codemo.iroads.Domain.crowdSourcing;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class LocationData {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String Id;
    @Field
    private String userID;
    @Field
    private String dataType;
    @Field
    private List<Location> locations;
}
