package com.example.lap03;

public class User {
    //Attribute
    String Gmail;
    String UserName;
    String Password;

    //getter Method
    public String getGmail() {
        return Gmail;
    }
    public String getUserName() {
        return UserName;
    }
    public String getPassword() {
        return Password;
    }

    //setter Method
    public void setGmail(String Gmail){
        this.Gmail = Gmail;
    }
    public void setUserName(String UserName){
        this.UserName = UserName;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    //method
    void view_profile(){

    System.out.println(Gmail);
    System.out.println(UserName);
    System.out.println(Password);
    }

}
