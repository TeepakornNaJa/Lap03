package com.example.lap03;

import java.util.Date;

public class Note {
    //Attribute
    String title;
    String context;
    String createdDate;

    //Method
    void getSummary(){
    System.out.println(title);
    System.out.println(context);
    System.out.println(createdDate);
    }

}
