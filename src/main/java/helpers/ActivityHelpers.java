package main.java.helpers;

import main.java.pojo.community.activities.CreatePoll;

import java.util.ArrayList;

public class ActivityHelpers {
    public static CreatePoll createBodyForCreatePoll(int post_id, String content, ArrayList options) {
        CreatePoll createPoll = new CreatePoll();
        createPoll.setPostId(post_id);
        createPoll.setContent(content);
        createPoll.setOptions(options);
        return createPoll;
    }
}
