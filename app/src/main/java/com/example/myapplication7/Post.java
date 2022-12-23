package com.example.myapplication7;

import java.io.Serializable;

public class Post implements Serializable {

    public String nameParty,nameStory;


    public Post(){

    }

    public Post( String nameParty, String nameStory) {

        this.nameParty = nameParty;
        this.nameStory = nameStory;
    }
}
