package com.example.android.afinal;

public class CoachAdvice {


    String name = "";
    String email = "";
    String topic = "";
    String description = "";
    String gender = "";

    public CoachAdvice(String name, String email, String topic, String description,String gender){
        this.name = name;
        this.email = email;
        this.topic = topic;
        this.description = description;
        this.gender =gender;
    }

    public String getName(){
        return name;
    }


    public String getEmail(){
        return email;
    }


    public String getTopic(){
        return topic;
    }

    public String getDescription(){
        return description;
    }

    public String getGender(){
        return gender;
    }
}

