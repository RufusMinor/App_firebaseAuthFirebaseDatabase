package com.example.myapplication7;

import java.io.Serializable;

public class Post implements Serializable {

    public String nameParty,nameStory, key;
    int datePost;


    public Post(){

    }

    public String getNameParty() {
        return nameParty;
    }

    public String getNameStory() {
        return nameStory;
    }

    public int getDatePost() {
        return datePost;
    }

    public String getKey() {
        return key;
    }

    public Post(String nameParty, String nameStory, int datePost, String key) {

        this.nameParty = nameParty;
        this.nameStory = nameStory;
        this.datePost=datePost;
        this.key=key;
    }
}
