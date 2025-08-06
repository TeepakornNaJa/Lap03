package com.example.lap03;

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

    public Note() {
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public boolean isChecklist() { return isChecklist; }
    public User getOwner() { return owner; }

    public void setTitle(String strOfTitile) {
    }
}





