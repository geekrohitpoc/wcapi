package main.java.pojo.trip;

import java.util.List;

public class ManageTripActivity {
    private int tripId;
    private int userId;

    public int getTripId() {
        return tripId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public End getEnd() {
        return end;
    }

    public void setEnd(End end) {
        this.end = end;
    }

    public List<PausedResume> getPausedResume() {
        return pausedResume;
    }

    public void setPausedResume(List<PausedResume> pausedResume) {
        this.pausedResume = pausedResume;
    }

    public List<Analytics> getAnalytics() {
        return analytics;
    }

    public void setAnalytics(List<Analytics> analytics) {
        this.analytics = analytics;
    }

    public List<RouteRecord> getRouteRecord() {
        return routeRecord;
    }

    public void setRouteRecord(List<RouteRecord> routeRecord) {
        this.routeRecord = routeRecord;
    }

    private String id;
    private int categoryId;
    private String name;
    private int active;
    private Start start;
    private End end;
    private List<PausedResume> pausedResume;
    private List<Analytics> analytics;
    private List<RouteRecord> routeRecord;
}
