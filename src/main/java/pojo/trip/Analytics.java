package main.java.pojo.trip;

public class Analytics {
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    public int getCalariesBerned() {
        return calariesBerned;
    }

    public void setCalariesBerned(int calariesBerned) {
        this.calariesBerned = calariesBerned;
    }

    private int speed;
    private String time;
    private int distanceCovered;
    private int calariesBerned;

}
