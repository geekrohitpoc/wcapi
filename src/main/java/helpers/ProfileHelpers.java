package main.java.helpers;

import main.java.pojo.profile.*;

import java.util.ArrayList;
import java.util.List;

public class ProfileHelpers {

    public static FollowUser createBodyForFollowUser(int initiator_user_id, int friend_user_id){
        FollowUser followUser = new FollowUser();
        followUser.setInitiatorUserId(initiator_user_id);
        followUser.setFriendUserId(friend_user_id);
        return followUser;
    }

    public static AcceptFollower createBodyForAcceptFollower(int initiator_user_id, int friend_user_id){
        AcceptFollower acceptFollower = new AcceptFollower();
        acceptFollower.setInitiatorUserId(initiator_user_id);
        acceptFollower.setFriendUserId(friend_user_id);
        return acceptFollower;
    }

    public static EditComment createBodyForEditComment(String content){
        EditComment editComment = new EditComment();
        editComment.setContent(content);
        return editComment;
    }

    public static Meta createBodyForMeta(String middle_name, int height, String profile_visibility, boolean post_notification, boolean group_notification, boolean live_notification, boolean message_notification){
        Meta meta = new Meta();
        meta.setMiddleName(middle_name);
        meta.setHeight(height);
        meta.setProfileVisibility(profile_visibility);
        meta.setPostNotification(post_notification);
        meta.setGroupNotification(group_notification);
        meta.setLiveNotification(live_notification);
        meta.setMessageNotification(message_notification);
        return meta;
    }

    public static EditUserProfile createBodyForEditUserProfile(String first_name, String description, Meta meta){
        EditUserProfile editUserProfile = new EditUserProfile();
        editUserProfile.setFirstName(first_name);
        editUserProfile.setDescription(description);
        editUserProfile.setMeta(meta);
        return editUserProfile;
    }

    public static UserFavActivities creatBodyForUserFavActivities(ArrayList ids){
        UserFavActivities userFavActivities = new UserFavActivities();
        userFavActivities.setIds(ids);
        return userFavActivities;
    }

}
