package main.java.pojo.community.events;

public class CreateEventFields {
    private String media;
    private String start;
    private String end;
    private String whatToExpect;
    private String visibilityRule;

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getWhatToExpect() {
        return whatToExpect;
    }

    public void setWhatToExpect(String whatToExpect) {
        this.whatToExpect = whatToExpect;
    }

    public String getVisibilityRule() {
        return visibilityRule;
    }

    public void setVisibilityRule(String visibilityRule) {
        this.visibilityRule = visibilityRule;
    }

    public String getChatRule() {
        return chatRule;
    }

    public void setChatRule(String chatRule) {
        this.chatRule = chatRule;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    private String chatRule;
    private String topic;
    private String type;
    private String eventStatus;


}
