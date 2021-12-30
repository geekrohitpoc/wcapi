package main.java.helpers;

import main.java.pojo.chat.*;

public class CommonHelpers {
    public static AddRoom createBodyForAddRoom(String room_name, int created_by, String created_by_username, boolean is_group, String receiver_username, int receiver_user_id ){
        AddRoom addRoom = new AddRoom();
        addRoom.setRoomName(room_name);
        addRoom.setCreatedBy(created_by);
        addRoom.setCreatedByUsername(created_by_username);
        addRoom.setGroup(is_group);
        addRoom.setReceiverUsername(receiver_username);
        addRoom.setReceiverUserId(receiver_user_id);
        return addRoom;
    }

    public static AddMessage createBodyForAddMessage(String message, int room_id, int participant_id, int parent_id, int user_id, String username, String receiver_username, int receiver_user_id, String media_url, int media_type_id){
        AddMessage addMessage = new AddMessage();
        addMessage.setMessage(message);
        addMessage.setRoomId(room_id);
        addMessage.setParticipantId(participant_id);
        addMessage.setParentId(parent_id);
        addMessage.setUserId(user_id);
        addMessage.setUsername(username);
        addMessage.setReceiverUsername(receiver_username);
        addMessage.setReceiverUserId(receiver_user_id);
        addMessage.setMediaUrl(media_url);
        addMessage.setMediaTypeId(media_type_id);
        return addMessage;
    }

    public static DeleteMessage createBodyForDeleteMessage(int room_id, int message_id, int user_id, String username, String receiver_username, int receiver_user_id){
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setRoomId(room_id);
        deleteMessage.setMessageId(message_id);
        deleteMessage.setUserId(user_id);
        deleteMessage.setUsername(username);
        deleteMessage.setReceiverUsername(receiver_username);
        deleteMessage.setReceiverUserId(receiver_user_id);
        return deleteMessage;
    }

    public static DeleteConversation createBodyForDeleteConversation(int participant_id, int deleted_by){
        DeleteConversation deleteConversation = new DeleteConversation();
        deleteConversation.setParticipantId(participant_id);
        deleteConversation.setDeletedBy(deleted_by);
        return deleteConversation;
    }

    public static GetUserChatMessages createBodyForGetUserChatMessages(int room_id, int participant_id, int user_id){
        GetUserChatMessages getUserChatMessages = new GetUserChatMessages();
        getUserChatMessages.setRoomId(room_id);
        getUserChatMessages.setParticipantId(participant_id);
        getUserChatMessages.setUserId(user_id);
        return getUserChatMessages;
    }

    public static GetChatUsersList createBodyForGetChatUsersList(int user_id){
        GetChatUsersList getChatUsersList = new GetChatUsersList();
        getChatUsersList.setUserId(user_id);
        return getChatUsersList;
    }

    public static GetChatRequestsList createBodyForGetChatRequestsList(int user_id){
        GetChatRequestsList getChatRequestsList = new GetChatRequestsList();
        getChatRequestsList.setUserId(user_id);
        return getChatRequestsList;
    }

    public static MarkUserChatAsRead createBodyForMarkUserChatAsRead(int participant_id, int user_id, String username, String receiver_username, int receiver_user_id){
        MarkUserChatAsRead markUserChatAsRead = new MarkUserChatAsRead();
        markUserChatAsRead.setParticipantId(participant_id);
        markUserChatAsRead.setUserId(user_id);
        markUserChatAsRead.setUsername(username);
        markUserChatAsRead.setReceiversUsername(receiver_username);
        markUserChatAsRead.setReceiverUserId(receiver_user_id);
        return markUserChatAsRead;
    }

    public static SendChatRequest createBodyForSendChatRequest(int from_user_id, String from_username, String to_username, int to_user_id){
        SendChatRequest sendChatRequest = new SendChatRequest();
        sendChatRequest.setFromUserId(from_user_id);
        sendChatRequest.setFromUsername(from_username);
        sendChatRequest.setToUsername(to_username);
        sendChatRequest.setToUserId(to_user_id);
        return sendChatRequest;
    }

    public static UpdateChatRequest createBodyForUpdateChatRequest(int participant_id, int current_user_id, String current_username, String sender_username, int sender_user_id, int request_status){
        UpdateChatRequest updateChatRequest = new UpdateChatRequest();
        updateChatRequest.setParticipantId(participant_id);
        updateChatRequest.setCurrentUserId(current_user_id);
        updateChatRequest.setCurrentUsername(current_username);
        updateChatRequest.setSenderUsername(sender_username);
        updateChatRequest.setSenderUserId(sender_user_id);
        updateChatRequest.setRequestStatus(request_status);
        return updateChatRequest;
    }

    public static CheckRoom createBodyForCheckRoom(int sender_user_id, String sender_username, int receiver_user_id, String receiver_username){
        CheckRoom checkRoom = new CheckRoom();
        checkRoom.setSenderUserId(sender_user_id);
        checkRoom.setSenderUsername(sender_username);
        checkRoom.setReceiverUserId(receiver_user_id);
        checkRoom.setReceiverUsername(receiver_username);
        return checkRoom;
    }

    public static CreateGroup createBodyForCreateGroup(String room_name, int created_by, String created_by_username){
        CreateGroup createGroup = new CreateGroup();
        createGroup.setRoomName(room_name);
        createGroup.setCreatedBy(created_by);
        createGroup.setCreatedByUsername(created_by_username);
        return createGroup;
    }

    public static UpdateGroupName createBodyForUpdateGroupName(int room_id, String room_name, int created_by, String created_by_username, int participant_id){
        UpdateGroupName updateGroupName = new UpdateGroupName();
        updateGroupName.setRoomId(room_id);
        updateGroupName.setRoomName(room_name);
        updateGroupName.setCreatedBy(created_by);
        updateGroupName.setCreatedByUsername(created_by_username);
        updateGroupName.setParticipantId(participant_id);
        return updateGroupName;
    }

    public static AddGroupMembers createBodyForGroupMembers(int room_id, int created_by, String created_by_username){
        AddGroupMembers addGroupMembers = new AddGroupMembers();
        addGroupMembers.setRoomId(room_id);
        addGroupMembers.setCreatedBy(created_by);
        addGroupMembers.setCreatedByUsername(created_by_username);
        return addGroupMembers;
    }

    public static DeleteGroup createBodyForDeleteGroup(int room_id, int deleted_by, String deleted_by_username){
        DeleteGroup deleteGroup = new DeleteGroup();
        deleteGroup.setRoomId(room_id);
        deleteGroup.setDeletedBy(deleted_by);
        deleteGroup.setDeletedByUsername(deleted_by_username);
        return deleteGroup;
    }

    public static LeaveGroup createBodyForLeaveGroup(int room_id, int user_id, String username, int deleted_by, String deleted_by_username, int participant_id){
        LeaveGroup leaveGroup = new LeaveGroup();
        leaveGroup.setRoomId(room_id);
        leaveGroup.setUserId(user_id);
        leaveGroup.setUsername(username);
        leaveGroup.setDeletedBy(deleted_by);
        leaveGroup.setDeletedByUsername(deleted_by_username);
        leaveGroup.setParticipantId(participant_id);
        return leaveGroup;
    }

    public static ManageBlackList createBodyForManageBlackList(int user_id, int blocked_by, boolean is_blocked){
        ManageBlackList manageBlackList = new ManageBlackList();
        manageBlackList.setUserId(user_id);
        manageBlackList.setBlockedBy(blocked_by);
        manageBlackList.setBlocked(is_blocked);
        return manageBlackList;
    }
}
