package com.example.lap03;

import java.util.List;

public class CheckListNote extends Note {
    private List<String> items;

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
