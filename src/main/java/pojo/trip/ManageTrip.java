package main.java.pojo.trip;

public class ManageTrip {

    public String getTripName() {
        return tripName;
    }

    public String getPurchased_trip_id() {
        return purchased_trip_id;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public void setPurchased_trip_id(String purchased_trip_id) {
        this.purchased_trip_id = purchased_trip_id;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIs_purchased() {
        return is_purchased;
    }

    public void setIs_purchased(int is_purchased) {
        this.is_purchased = is_purchased;
    }

    public int getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(int is_completed) {
        this.is_completed = is_completed;
    }


    public int getIs_published() {
        return is_published;
    }

    public void setIs_published(int is_published) {
        this.is_published = is_published;
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

    private String tripId;
    private String tripName;
    private int userId;
    private int is_purchased;
    private int is_completed;
    private String purchased_trip_id;
    private int is_published;
    private Start start;
    private End end;

}
