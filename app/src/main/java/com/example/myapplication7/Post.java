package com.example.myapplication7;

import java.io.Serializable;

public class Post implements Serializable {

    public String nameParty,nameStory,datePost, key;
    //public int key;


    public Post(){

    }

    public Post( String nameParty, String nameStory,String datePost, String key) {

        this.nameParty = nameParty;
        this.nameStory = nameStory;
        this.datePost=datePost;
        this.key=key;
    }
}
