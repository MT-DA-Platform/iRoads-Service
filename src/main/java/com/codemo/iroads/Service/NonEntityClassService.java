package com.codemo.iroads.Service;

import com.codemo.iroads.Domain.*;
import com.couchbase.client.java.document.json.JsonObject;

import java.util.List;


public interface NonEntityClassService {
    String getJourneyIds();

    List<JourneyIDNamePair> getJourneyNameObjects();

    String getLocationsByjourneyID(String journeyID);

    List<Tag> getTagsByJourneyID(String journeyID);

    List<LatLonTag> getAllTaggs();

    List<JourneyIDNamePair> getTaggedJourneyIDs();

    Summary getSummary();

    List<NameID> getAllTaggedJourneys();

    List<TagsWithName> getTagsWithNames();

    List<ColorRange> getAllColorRanges();

    List<JsonObject> getAllByLocation(double lon, double lat);

}
