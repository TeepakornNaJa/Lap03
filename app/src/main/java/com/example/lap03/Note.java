package com.example.lap03;

public abstract class Note {
    //Attribute
    String title;
    String context;
    String createdDate;

    //getter
    public String getTitle(){
        return title;
    }
    public String getContext() {
        return context;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    //setter
    public void setTitle(String title){
        this.title = title;
    }
    public void setContext(String context){
        this.context = context;
    }
    public void setCreatedDate(String createdDate){
        this.createdDate = createdDate;
    }
    //Method
    public abstract String getSummary();
}



