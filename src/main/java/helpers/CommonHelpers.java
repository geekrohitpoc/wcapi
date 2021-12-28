package main.java.helpers;

import main.java.pojo.flag.AddFlag;
import main.java.pojo.flag.GetPublicFlagByCoordinate;
import main.java.pojo.flag.*;
import main.java.pojo.image.InsertImage;
import main.java.pojo.note.InsertNote;
import main.java.pojo.note.UpdateNote;
import main.java.pojo.trip.*;
import main.java.pojo.video.InsertVideo;
import main.java.pojo.voice.InsertVoice;

import java.util.ArrayList;

public class CommonHelpers {
    public static ManageTrip createBodyForManageTripApi(String tripId, int userId,Start start, End end, String tripName, int is_purchased, int is_completed, int is_published, String purchased_trip_id){
        ManageTrip manageTrip = new ManageTrip();
        manageTrip.setTripId(tripId);
        manageTrip.setUserId(userId);
        manageTrip.setTripName(tripName);
        manageTrip.setIs_purchased(is_purchased);
        manageTrip.setIs_completed(is_completed);
        manageTrip.setIs_published(is_published);
        manageTrip.setStart(start);
        manageTrip.setEnd(end);
        manageTrip.setPurchased_trip_id(purchased_trip_id);
        return manageTrip;
    }

    public static Start createBodyForStart(String placeName, Coordinates coordinates, String createdOn){
        Start start = new Start();
        start.setPlaceName(placeName);
        start.setCoordinates(coordinates);
        start.setCreatedOn(createdOn);
        return start;
    }

    public static End createBodyForEnd(String placeName, Coordinates coordinates, String endAt){
        End end = new End();
        end.setPlaceName(placeName);
        end.setCoordinates(coordinates);
        end.setEndAt(endAt);
        return end;
    }

    public static Coordinates createBodyForCoordinates(double latitude, double longitude){
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(latitude);
        coordinates.setLongitude(longitude);
        return coordinates;
    }

    public static ManageTripActivity createBodyForManageTripActivity(int tripId, int userId, String id, int categoryId, String name, int active, ArrayList<PausedResume> pausedResume, ArrayList<Analytics> analytics, ArrayList<RouteRecord> routeRecord, Start start, End end){
        ManageTripActivity manageTripActivity = new ManageTripActivity();
        manageTripActivity.setTripId(tripId);
        manageTripActivity.setUserId(userId);
        manageTripActivity.setId(id);
        manageTripActivity.setCategoryId(categoryId);
        manageTripActivity.setName(name);
        manageTripActivity.setActive(active);
        manageTripActivity.setPausedResume(pausedResume);
        manageTripActivity.setAnalytics(analytics);
        manageTripActivity.setRouteRecord(routeRecord);
        manageTripActivity.setStart(start);
        manageTripActivity.setEnd(end);
        return manageTripActivity;
    }

    public static RouteRecord createBodyForRouteRecord(double latitude, double longitude){
        RouteRecord routeRecord = new RouteRecord();
        routeRecord.setLatitude(latitude);
        routeRecord.setLongitude(longitude);
        return routeRecord;
    }

    public static Analytics createBodyForAnalytics(int speed, String time, int distanceCovered, int calariesBerned){
        Analytics analytics = new Analytics();
        analytics.setSpeed(speed);
        analytics.setTime(time);
        analytics.setDistanceCovered(distanceCovered);
        analytics.setCalariesBerned(calariesBerned);
        return analytics;
    }

    public static PausedResume createBodyForPausedResume(String pausedAt, String resumedAt, PausedLocation pausedLocation){
        PausedResume pausedResume = new PausedResume();
        pausedResume.setPausedAt(pausedAt);
        pausedResume.setResumedAt(resumedAt);
        pausedResume.setPausedLocation(pausedLocation);
        return pausedResume;
    }

    public static PausedLocation createBodyForPausedLocation(String placeName, Coordinates coordinates){
        PausedLocation pausedLocation = new PausedLocation();
        pausedLocation.setPlaceName(placeName);
        pausedLocation.setCoordinates(coordinates);
        return pausedLocation;
    }

    public static UpdateTripStatus createBodyForUpdateTripStatus(int trip_id, boolean is_published){
        UpdateTripStatus updateTripStatus = new UpdateTripStatus();
        updateTripStatus.setTrip_id(trip_id);
        updateTripStatus.setIs_published(is_published);
        return updateTripStatus;
    }

    public static AddFlag createBodyForAddFlag(String flag_name, double latitude, double longitude, boolean is_like, int trip_id, int category_id, int user_id){
        AddFlag addFlag = new AddFlag();
        addFlag.setFlag_name(flag_name);
        addFlag.setLatitude(latitude);
        addFlag.setLongitude(longitude);
        addFlag.setIs_like(is_like);
        addFlag.setTrip_id(trip_id);
        addFlag.setCategory_id(category_id);
        addFlag.setUser_id(user_id);
        return addFlag;
    }

    public static GetFlagByMe createBodyForGetFlagByMe(double latitude, double longitude, int user_id){
        GetFlagByMe flagByMe = new GetFlagByMe();
        flagByMe.setLatitude(latitude);
        flagByMe.setLongitude(longitude);
        flagByMe.setUser_id(user_id);
        return flagByMe;
    }

    public static GetFlagByOthers createBodyForGetFlagByOthers(double latitude, double longitude, int user_id){
        GetFlagByOthers flagByOthers = new GetFlagByOthers();
        flagByOthers.setLatitude(latitude);
        flagByOthers.setLongitude(longitude);
        flagByOthers.setUser_id(user_id);
        return flagByOthers;
    }

    public static GetPublicFlagByCoordinate createBodyForGetPublicFlagByCoordinates(double latitude, double longitude, int user_id){
        GetPublicFlagByCoordinate publicFlagByCoordinate = new GetPublicFlagByCoordinate();
        publicFlagByCoordinate.setLatitude(latitude);
        publicFlagByCoordinate.setLongitude(longitude);
        publicFlagByCoordinate.setUser_id(user_id);
        return publicFlagByCoordinate;
    }

    public static UpdateFlagStatus createBodyForUpdateFlagStatus(int flag_id, boolean is_like, int user_id){
        UpdateFlagStatus updateFlagStatus = new UpdateFlagStatus();
        updateFlagStatus.setFlag_id(flag_id);
        updateFlagStatus.setIs_like(is_like);
        updateFlagStatus.setUser_id(user_id);
        return  updateFlagStatus;
    }

    public static InsertNote createBodyForInsertNote(String note, double latitude, double longitude, String location_name, int trip_id, int user_id, int activity_id){
        InsertNote insertNote = new InsertNote();
        insertNote.setNote(note);
        insertNote.setLatitude(latitude);
        insertNote.setLongitude(longitude);
        insertNote.setLocation_name(location_name);
        insertNote.setTrip_id(trip_id);
        insertNote.setUser_id(user_id);
        insertNote.setActivity_id(activity_id);
        return insertNote;
    }

    public static UpdateNote createBodyForUpdateNote(String note, int id){
        UpdateNote updateNote = new UpdateNote();
        updateNote.setNote(note);
        updateNote.setId(id);
        return updateNote;
    }

    public static InsertVideo createBodyForInsertVideo(String filename, String duration, String video_url, double latitude, double longitude, String location_name, int trip_id, int user_id, int activity_id){
        InsertVideo insertVideo = new InsertVideo();
        insertVideo.setFilename(filename);
        insertVideo.setDuration(duration);
        insertVideo.setVideo_url(video_url);
        insertVideo.setLatitude(latitude);
        insertVideo.setLongitude(longitude);
        insertVideo.setLocation_name(location_name);
        insertVideo.setTrip_id(trip_id);
        insertVideo.setUser_id(user_id);
        insertVideo.setActivity_id(activity_id);
        return insertVideo;
    }

    public static InsertVoice createBodyForInsertVoice(String filename, String duration, String video_url, double latitude, double longitude, String location_name, int trip_id, int user_id, int activity_id){
        InsertVoice insertVoice = new InsertVoice();
        insertVoice.setFilename(filename);
        insertVoice.setDuration(duration);
        insertVoice.setVoice_url(video_url);
        insertVoice.setLatitude(latitude);
        insertVoice.setLongitude(longitude);
        insertVoice.setLocation_name(location_name);
        insertVoice.setTrip_id(trip_id);
        insertVoice.setUser_id(user_id);
        insertVoice.setActivity_id(activity_id);
        return insertVoice;
    }

    public static InsertImage createBodyForInsertImage(String image_url, double latitude, double longitude, String location_name, int trip_id, int user_id, int activity_id){
        InsertImage insertImage = new InsertImage();
        insertImage.setImage_url(image_url);
        insertImage.setLatitude(latitude);
        insertImage.setLongitude(longitude);
        insertImage.setLocation_name(location_name);
        insertImage.setTrip_id(trip_id);
        insertImage.setUser_id(user_id);
        insertImage.setActivity_id(activity_id);
        return insertImage;
    }

}
