package com.example.pedla;

public class bookingmodel {
    String Date,Time,Cycle,Store,Accessory,Total_Amount;

    public bookingmodel() {
    }

    public bookingmodel(String date, String time, String cycle, String store, String accessory, String total_Amount) {
        Date = date;
        Time = time;
        Cycle = cycle;
        Store = store;
        Accessory = accessory;
        Total_Amount = total_Amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getCycle() {
        return Cycle;
    }

    public void setCycle(String cycle) {
        Cycle = cycle;
    }

    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }

    public String getAccessory() {
        return Accessory;
    }

    public void setAccessory(String accessory) {
        Accessory = accessory;
    }

    public String getTotal_Amount() {
        return Total_Amount;
    }

    public void setTotal_Amount(String total_Amount) {
        Total_Amount = total_Amount;
    }
}
