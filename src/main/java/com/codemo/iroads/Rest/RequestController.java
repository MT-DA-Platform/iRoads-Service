package com.codemo.iroads.Rest;

import com.codemo.iroads.Domain.*;
import com.codemo.iroads.Domain.commonFormat.CommonFormat;
import com.codemo.iroads.Domain.commonFormat.DataType;
import com.codemo.iroads.Domain.commonFormat.Location;
import com.codemo.iroads.Domain.commonFormat.Record;
import com.codemo.iroads.Service.DataItemService;
import com.codemo.iroads.Service.IRIService;
import com.codemo.iroads.Service.NonEntityClassService;
import com.codemo.iroads.Service.PredictionService;
import com.codemo.iroads.Util.Util;
import com.couchbase.client.java.document.json.JsonObject;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dushan on 4/23/18.
 */

@RestController
public class RequestController {

    Gson gson = new Gson();
    Logger logger = LogManager.getLogger(RequestController.class);

    @Autowired
    DataItemService  dataItemService;

    @Autowired
    NonEntityClassService nonEntityClassService;

    @Autowired
    PredictionService predictionService;

    @Autowired
    IRIService iriService;

    @RequestMapping("/")
    public String root(){
        return Util.welcome();
    }

    @RequestMapping("/getJourneyIDs")
    public String getJourneyIDs(){
        return nonEntityClassService.getJourneyIds();
    }

    @RequestMapping("/getJourneyNames")
    public List<JourneyIDNamePair> getJourneyNames(){
        return nonEntityClassService.getJourneyNameObjects();
    }

    @RequestMapping("/getByjourneyID")
    public List<DataItem> getDataItemByJourneyID(@RequestParam("journeyID") String journeyID){
        return dataItemService.getDataItemByJourneyID(journeyID);
}

    @RequestMapping("/getLocationsByjourneyID")
    public String getLocationsByjourneyID(@RequestParam("journeyID") String journeyID){
        return nonEntityClassService.getLocationsByjourneyID(journeyID);
    }

    @RequestMapping("/getAverageByjourneyID")
    public List<DataItem> getDataAverageByJourneyID(@RequestParam("journeyID") String journeyID){
        return dataItemService.getAverageFilterdData(journeyID);
    }

    @RequestMapping(value="/getCsvByjourneyID" ,produces = "text/csv")
    public void getCsvDataItemByJourneyID(@RequestParam("journeyID") String journeyID, HttpServletResponse response) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        dataItemService.getCsvDataItemByJourneyID(journeyID,response);
    }

    @RequestMapping("/getGraph")
    public String getGraphData(@RequestParam("journeyID") String journeyID,@RequestParam("splitBy") int splitBy){
        return dataItemService.getAccelerationGraphDataByJourneyID(journeyID,splitBy);
    }

    @RequestMapping("/getGraphGyro")
    public String getGraphDataGyro(@RequestParam("journeyID") String journeyID,@RequestParam("splitBy") int splitBy){
        return dataItemService.getGyroGraphDataByJourneyID(journeyID,splitBy);
    }

    @RequestMapping("/getTags")
    public List<Tag> getTags(@RequestParam("journeyID") String journeyID){
        return nonEntityClassService.getTagsByJourneyID(journeyID);
    }

    @RequestMapping("/getTaggedIds")
    public List<JourneyIDNamePair> getTaggedJourneyIDs(){
        return nonEntityClassService.getTaggedJourneyIDs();
    }

    @RequestMapping("/getTaggedNames")
    public List<NameID> getAllTaggedJourneys(){
        return nonEntityClassService.getAllTaggedJourneys();
    }

    @RequestMapping("/getRoadAnomalies")
    public List<LatLonTag> getRoadAnomalies(){
        return nonEntityClassService.getAllTaggs();
    }


    @RequestMapping("/getJourneySegments")
    public SegmentInfoWrapper getAllTags(@RequestParam("journeyID") String journeyID,@RequestParam("lat") double lat,@RequestParam("lon") double lon,@RequestParam(value = "threshold",defaultValue = "1.0") Double threshold,@RequestParam(value = "segmentLength",defaultValue = "100") Integer segmentLength){
        SegmentInfoWrapper segmentInfoWrapper = dataItemService.getJourneySegments(journeyID, lat, lon,threshold,segmentLength);
        return segmentInfoWrapper;
    }

    @RequestMapping("/getSummary")
    public Summary getSummary(){
        return nonEntityClassService.getSummary();
    }

    @RequestMapping("/getPredictionGroups")
    public List<PredictionGroupWrapper> getPredictionGroups(){
        List<PredictionGroupWrapper> predictionGroups = predictionService.getPredictionGroups();
        return predictionGroups;
    }

    @RequestMapping("/getPredictionsByGroup")
    public List<Prediction> getPredictionsByGroup(@RequestParam("groupID") String groupID){
        List<Prediction> predictionsByGroupId = predictionService.getPredictionsByGroupId(groupID);
        return predictionsByGroupId;
    }

    @RequestMapping("/getAllPredictions")
    public List<Prediction> getAllPredictionsp(){
        List<Prediction> predictions= predictionService.getAllPredictions();
        return predictions;
    }

    @RequestMapping("/getAllIriEq")
    public List<IRISegmentParameter> getAllIRISegmentParameters(){
        List<IRISegmentParameter> all= iriService.getAll();
        return all;
    }

    @RequestMapping("/getIriEqBySegment")
    public IRISegmentParameter getIRIEqBySegment(@RequestParam("segmentLength") int segmentLength){
        IRISegmentParameter iriEqBySegment = iriService.getIRIEqBySegment(segmentLength);
        return iriEqBySegment;
    }

    @RequestMapping("/getTagsWithNames")
    public List<TagsWithName> getTagsWithNames(){
        List<TagsWithName> tagsWithNames = nonEntityClassService.getTagsWithNames();
        return tagsWithNames;
    }

    @RequestMapping("/getColorRanges")
    public List<ColorRange> getAllColorRanges(){
        List<ColorRange> allColorRanges = nonEntityClassService.getAllColorRanges();
        return allColorRanges;
    }

//    @RequestMapping("/getAll")
//    public List<DataItem> getAll(){
//        return dataItemService.getAll();
//    }


    //new
    //getAllByLocation
    @RequestMapping("/getAllByLocation")
    public CommonFormat getAllByLocation(@RequestParam("lon") String lon, @RequestParam("lat") String lat){
        //todo format data
        CommonFormat commonFormat = new CommonFormat();

        Location location = new Location();
        location.setLongitude(Double.parseDouble(lon));
        location.setLatitude(Double.parseDouble(lat));
        location.setName("");

        commonFormat.setLocation(location);

        DataType dataType = new DataType();
        dataType.setType("iroads-data");
        dataType.setSubtype("location data");

        commonFormat.setType(dataType);

        List<JsonObject> dataItems = nonEntityClassService.getAllByLocation(Double.parseDouble(lon),Double.parseDouble(lat));
        List<Record> records = new ArrayList<Record>();
        for(JsonObject object : dataItems){
            Record record = populateRecord(object);
            records.add(record);
        }

        commonFormat.setRecords(records);
        logger.info("getAllByLocation lon ="+lon+"and lat ="+lat+" : ",gson.toJson(commonFormat));
        return commonFormat;
    }

    Record populateRecord(JsonObject object){
        Record record = new Record();
        record.setAcceX(object.getDouble("acceX"));
        record.setAcceX_raw(object.getString("acceX_raw"));
        record.setAcceY(object.getDouble("acceY"));
        record.setAcceY_raw(object.getString("acceY_raw"));
        record.setAcceZ(object.getDouble("acceZ"));
        record.setAcceZ_raw(object.getString("acceZ_raw"));
        record.setGpsSpeed(object.getDouble("gpsSpeed"));
        record.setGyroX(object.getString("gyroX"));
        record.setGyroY(object.getString("gyroY"));
        record.setGyroZ(object.getString("gyroZ"));
        record.setLat(object.getString("lat"));
        record.setLon(object.getString("lon"));
        record.setMagnetX(object.getString("magnetX"));
        record.setMagnetY(object.getString("magnetY"));
        record.setMagnetZ(object.getString("magnetZ"));
        record.setObdRpm(object.getString("obdRpm"));
        record.setTime(object.getLong("time"));
        return record;
    }

}
