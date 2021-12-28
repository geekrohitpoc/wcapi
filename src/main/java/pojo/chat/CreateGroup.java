package main.java.pojo.chat;

public class CreateGroup {
    private String roomName;
    private int createdBy;
    private int createdByUsername;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getCreatedByUsername() {
        return createdByUsername;
    }

    public void setCreatedByUsername(int createdByUsername) {
        this.createdByUsername = createdByUsername;
    }
}
