package main.java.pojo.profile;

public class Meta {
    private String middleName;
    private int height;
    private String profileVisibility;
    private boolean postNotification;
    private boolean groupNotification;
    private boolean liveNotification;
    private boolean messageNotification;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getProfileVisibility() {
        return profileVisibility;
    }

    public void setProfileVisibility(String profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

    public boolean isPostNotification() {
        return postNotification;
    }

    public void setPostNotification(boolean postNotification) {
        this.postNotification = postNotification;
    }

    public boolean isGroupNotification() {
        return groupNotification;
    }

    public void setGroupNotification(boolean groupNotification) {
        this.groupNotification = groupNotification;
    }

    public boolean isLiveNotification() {
        return liveNotification;
    }

    public void setLiveNotification(boolean liveNotification) {
        this.liveNotification = liveNotification;
    }

    public boolean isMessageNotification() {
        return messageNotification;
    }

    public void setMessageNotification(boolean messageNotification) {
        this.messageNotification = messageNotification;
    }
}
