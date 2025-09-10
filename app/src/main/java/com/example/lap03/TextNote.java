package com.example.lap03;

public class TextNote extends Note {
    //Attribute
    private String textContent;

    //getter method
    public  String getTextContent(){
        return textContent;
    }

    //setter Method
    public void setTextContent(String newContent){
        this.textContent = newContent;
    }

    //Method
    public String getSummary(){
        //System.out.prinln(title + ": " + textContent + " (" + createdDate + ")");
    }

}
