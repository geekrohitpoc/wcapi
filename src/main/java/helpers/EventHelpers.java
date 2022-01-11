package main.java.helpers;

import main.java.pojo.community.events.*;

import java.util.ArrayList;

public class EventHelpers {
    public static CreateEvents createBodyForCreateEvent(String status, String title, String content, ArrayList categories, CreateEventFields fields){
        CreateEvents createEvents = new CreateEvents();
        createEvents.setStatus(status);
        createEvents.setTitle(title);
        createEvents.setContent(content);
        createEvents.setCategories(categories);
        createEvents.setFields(fields);
        return createEvents;
    }

    public static CreateEventFields createBodyForCreateFields(String media, String start, String end, String what_to_expect, String visiblity_rule, String chat_rule, String topic, String type, String event_status){
        CreateEventFields fields = new CreateEventFields();
        fields.setMedia(media);
        fields.setStart(start);
        fields.setEnd(end);
        fields.setWhatToExpect(what_to_expect);
        fields.setVisibilityRule(visiblity_rule);
        fields.setChatRule(chat_rule);
        fields.setTopic(topic);
        fields.setType(type);
        fields.setEventStatus(event_status);
        return fields;
    }

    public static EditEventFields createBodyForEditFields(String media, String start, String end, String what_to_expect, String visiblity_rule, String chat_rule, String topic, String type){
        EditEventFields fields = new EditEventFields();
        fields.setMedia(media);
        fields.setStart(start);
        fields.setEnd(end);
        fields.setWhatToExpect(what_to_expect);
        fields.setVisibilityRule(visiblity_rule);
        fields.setChatRule(chat_rule);
        fields.setTopic(topic);
        fields.setType(type);
        return fields;
    }

    public static EditEvents createBodyForEditEvents(String status, String title, String content, ArrayList categories, EditEventFields fields){
        EditEvents editEvents = new EditEvents();
        editEvents.setStatus(status);
        editEvents.setTitle(title);
        editEvents.setContent(content);
        editEvents.setCategories(categories);
        editEvents.setFields(fields);
        return editEvents;
    }

    public static SaveLiveSessionId createBodyForSaveLiveSessionId(FieldEvents fieldEvents){
        SaveLiveSessionId saveLiveSessionId = new SaveLiveSessionId();
        saveLiveSessionId.setFields(fieldEvents);
        return saveLiveSessionId;
    }

    public static FieldEvents createBodyForFieldEvents(String live_session_id){
        FieldEvents fieldEvents = new FieldEvents();
        fieldEvents.setLiveSessionId(live_session_id);
        return fieldEvents;
    }

    public static CompleteEvent createBodyForCompleteEvent(CompleteEventFields completeEventFields){
        CompleteEvent completeEvent = new CompleteEvent();
        completeEvent.setFields(completeEventFields);
        return completeEvent;
    }

    public static CompleteEventFields createBodyForCompleteEvents(String recording, String event_status){
        CompleteEventFields completeEventFields = new CompleteEventFields();
        completeEventFields.setRecording(recording);
        completeEventFields.setEventStatus(event_status);
        return completeEventFields;
    }
}
