package main.java.pojo.community.events;

import java.util.ArrayList;

public class EditEvents {
    private String status;
    private String title;
    private String content;
    private ArrayList<Integer> categories;
    private EditEventFields fields;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Integer> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Integer> categories) {
        this.categories = categories;
    }

    public EditEventFields getFields() {
        return fields;
    }

    public void setFields(EditEventFields fields) {
        this.fields = fields;
    }
}
