package com.example.lap03;

import androidx.room.Entity;

import java.util.List;

public class CheckListNote extends Note {
    private List<String> items;
    @Entity
    public class NoteEntity {

        private Long id;
        private String title;
        private String createdDate;
        private String content;

        // constructor, getter, setter
    }

    public CheckListNote() {
        super(entity.title, entity.createdDate, entity.content);
    }

    //getter
    public List<String> getItems() {
        return items;
    }
    //setter
    public void setItems(List<String> items) {
        this.items = items;
    }


    public String getSummary() {
        String strItems = "";
        int noOfList = items.size();
        for(int i=0 ; i< noOfList ; i++){
            strItems = strItems + items.get(i);
        }
        //return title+":"+strItems+"("+createdDate+")";
        return title+":"+items.get(0)+"("+createdDate+")";
    }


}
