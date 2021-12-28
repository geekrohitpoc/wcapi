package main.java.pojo.trip;

public class PausedResume {
    public String getPausedAt() {
        return pausedAt;
    }

    public void setPausedAt(String pausedAt) {
        this.pausedAt = pausedAt;
    }

    public String getResumedAt() {
        return resumedAt;
    }

    public void setResumedAt(String resumedAt) {
        this.resumedAt = resumedAt;
    }

    public PausedLocation getPausedLocation() {
        return pausedLocation;
    }

    public void setPausedLocation(PausedLocation pausedLocation) {
        this.pausedLocation = pausedLocation;
    }

    private String pausedAt;
    private String resumedAt;
    private PausedLocation pausedLocation;
}
