package com.example.pedla;

public class MyStoreData {
    private String Storename;
    private String availablecycle;
    private String Distance;
    private Integer Storeimage;

    public MyStoreData(String storename, String availablecycle, String distance, Integer storeimage) {
        Storename = storename;
        this.availablecycle = availablecycle;
        Distance = distance;
        Storeimage = storeimage;
    }

    public String getStorename() {
        return Storename;
    }

    public void setStorename(String storename) {
        Storename = storename;
    }

    public String getAvailablecycle() {
        return availablecycle;
    }

    public void setAvailablecycle(String availablecycle) {
        this.availablecycle = availablecycle;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public Integer getStoreimage() {
        return Storeimage;
    }

    public void setStoreimage(Integer storeimage) {
        Storeimage = storeimage;
    }
}
