package com.example.myapplication7;

import java.io.Serializable;

public class Post implements Serializable {

    public String nameParty,nameStory, datePost;
    int timeStamp;


    public Post(){

    }

    public String getNameParty() {
        return nameParty;
    }

    public String getNameStory() {
        return nameStory;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public String getDatePost() {
        return datePost;
    }

    public Post(String nameParty, String nameStory, int timeStamp, String datePost) {

        this.nameParty = nameParty;
        this.nameStory = nameStory;
        this.timeStamp=timeStamp;
        this.datePost=datePost;
    }
}
