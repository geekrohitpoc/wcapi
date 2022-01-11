package main.java.helpers;

import main.java.pojo.community.members.AddMembers;

import java.util.ArrayList;

public class MemberHelpers {

    public static AddMembers createBodyForAddMembers(int post_id, ArrayList user_id){
        AddMembers addMembers = new AddMembers();
        addMembers.setPostId(post_id);
        addMembers.setUserId(user_id);
        return addMembers;
    }
}
