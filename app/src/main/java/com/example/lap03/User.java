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

        System.out.println("Gmail: " + Gmail);
        System.out.println("UserName: " + UserName);
        System.out.println("Password: " + Password);

    }
    public User(String Username, String Gmail, String Password) {
        this.UserName = Username;
        this.Gmail = Gmail;
        this.Password = Password;

    }

    public String getName() {return UserName;}

    public String getEmail() {return Gmail;}

}



