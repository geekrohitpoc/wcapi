package main.java.pojo.chat;

public class MarkUserChatAsRead {
      private int participantId;
      private int userId;
      private String username;
      private String receiversUsername;
      private int receiverUserId;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReceiversUsername() {
        return receiversUsername;
    }

    public void setReceiversUsername(String receiversUsername) {
        this.receiversUsername = receiversUsername;
    }

    public int getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(int receiverUserId) {
        this.receiverUserId = receiverUserId;
    }
}
