package com.example.onlinemusicappclient.Model;

public class Utility {
    public static String convertDuration(long duration){
    long mins = (duration / 1000) / 60;
    long sec = (duration / 1000) % 60;
    String converted = String.format("%d:%02d", mins,sec);
    return converted;
    }
}
