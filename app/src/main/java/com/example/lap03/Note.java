package com.example.lap03;

import java.util.Date;

public class Note {
    String createdDate;
    String title;
    String content;
    boolean isChecklist;
    User owner;

    public Note(String title, String content, boolean isChecklist, User owner) {
        this.title = title;
        this.content = content;
        this.isChecklist = isChecklist;
        this.owner = owner;
    }


    public Note(String title, Date createdDate, String content) {
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isChecklist() {
        return isChecklist;
    }

    public User getOwner() {
        return owner;
    }

    public void setTitle(String strOfTitile) {
    }

    public String getSummary() {
        if (content == null) return "";
        if (content.length() <= 30) {
            return content;
        } else {
            return content.substring(0, 30) + "...";
        }
    }
}





