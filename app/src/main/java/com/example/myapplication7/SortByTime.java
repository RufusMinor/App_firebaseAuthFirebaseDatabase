package com.example.myapplication7;

import java.util.Comparator;

public class SortByTime implements Comparator<Post> {
    @Override
    public int compare(Post o1, Post o2){
        return o2.getTimeStamp()-o1.getTimeStamp();
    }
}
