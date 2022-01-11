package main.java.pojo.community.events;

import java.util.ArrayList;

public class CreateEvents {
    private String status;

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

    public CreateEventFields getFields() {
        return fields;
    }

    public void setFields(CreateEventFields fields) {
        this.fields = fields;
    }

    private String title;
    private String content;
    private ArrayList<Integer> categories;
    private CreateEventFields fields;
}
