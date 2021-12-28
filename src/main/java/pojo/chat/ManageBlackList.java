package main.java.pojo.chat;

public class ManageBlackList {
    private int userId;
    private int blockedBy;
    private boolean isBlocked;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(int blockedBy) {
        this.blockedBy = blockedBy;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
