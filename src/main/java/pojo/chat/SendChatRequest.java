package main.java.pojo.chat;

public class SendChatRequest {
    private int fromUserId;
    private String fromUsername;
    private String toUsername;
    private int toUserId;

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int userId) {
        this.toUserId = userId;
    }
}

