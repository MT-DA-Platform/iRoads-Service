package com.codemo.iroads.Domain.commonFormat;

import com.codemo.iroads.Domain.DataItem;
import com.couchbase.client.java.document.json.JsonObject;

import java.util.List;

public class CommonFormat {

    private List<Record> records;

    private Location location;

    private DataType type;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }
}
