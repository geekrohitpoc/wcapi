package main.java.pojo.community.members;

import java.util.ArrayList;

public class AddMembers {
    private int postId;
    private ArrayList<Integer> userId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public ArrayList<Integer> getUserId() {
        return userId;
    }

    public void setUserId(ArrayList<Integer> userId) {
        this.userId = userId;
    }
}
