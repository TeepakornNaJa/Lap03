package com.example.lap03;

import java.util.Date;

public class TextNote {
    public Date createdDate;
    String title = "Text messaging";
    private String textContent = "Text messaging, or texting, is the act of composing and sending electronic messages";
    private String note;
    private User owner;

    public TextNote(String title, Date createdDate, String content) {
        this.title = title;
        this.textContent = content;
        this.note = note;

    }

    public TextNote() {
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void gettextContent() {
        this.note = textContent;
    }

    public String getNote() {
        return note;
    }

    public String getSummary() {
        return "Title: " + title + "\n"
                + "Content: " + textContent + "\n"
                + "Note: " + note + "\n"
                + owner.toString();
    }

    public String getTextContent() {
        return "";
    }
}