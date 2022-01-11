package main.java.helpers;

import main.java.pojo.community.group.*;

import java.util.ArrayList;

public class GroupHelpers {

    public static Fields createBodyForFields(String media, String location, String what_to_expect, String visiblity_rule, String chat_rule,String topic){
        Fields fields = new Fields();
        fields.setMedia(media);
        fields.setLocation(location);
        fields.setWhatToExpect(what_to_expect);
        fields.setVisibilityRule(visiblity_rule);
        fields.setChatRule(chat_rule);
        fields.setTopic(topic);
        return fields;
    }

    public static CreateGroup createBodyForCommunityCreateGroup(String status, String title, String content, ArrayList categories, Fields fields){
        CreateGroup createGroup = new CreateGroup();
        createGroup.setStatus(status);
        createGroup.setTitle(title);
        createGroup.setContent(content);
        createGroup.setCategories(categories);
        createGroup.setFields(fields);
        return createGroup;
    }

    public static EditGroup createBodyForCommunityEditGroup(String status, String title, String content, ArrayList categories, Fields fields){
        EditGroup editGroup = new EditGroup();
        editGroup.setStatus(status);
        editGroup.setTitle(title);
        editGroup.setContent(content);
        editGroup.setCategories(categories);
        editGroup.setFields(fields);
        return editGroup;
    }

    public static ChangeVisibilityOfGroup createBodyForChangeVisibilityofGroup(VisibilityRuleField visibilityRuleField){
        ChangeVisibilityOfGroup changeVisibilityOfGroup = new ChangeVisibilityOfGroup();
        changeVisibilityOfGroup.setFields(visibilityRuleField);
        return changeVisibilityOfGroup;
    }

    public static VisibilityRuleField createBodyForVisibilityRule(String visiblity_rule){
        VisibilityRuleField visibilityRuleField = new VisibilityRuleField();
        visibilityRuleField.setVisibilityRule(visiblity_rule);
        return visibilityRuleField;
    }

    public static CloseAndSaveGroupFields createBodyForCloseAndSaveGroupFields(boolean is_active){
        CloseAndSaveGroupFields closeAndSaveGroupFields = new CloseAndSaveGroupFields();
        closeAndSaveGroupFields.setIs_active(is_active);
        return closeAndSaveGroupFields;
    }

    public static CloseAndSaveGroup createBodyForCloseAndSaveGroup(CloseAndSaveGroupFields closeAndSaveGroupFields){
        CloseAndSaveGroup closeAndSaveGroup = new CloseAndSaveGroup();
        closeAndSaveGroup.setCloseAndSaveGroupFields(closeAndSaveGroupFields);
        return closeAndSaveGroup;
    }

}
