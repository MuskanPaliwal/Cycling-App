package com.example.pedla;

public class bookingmodel {
    String Date,Time,Cycle,Store,Accessory,Total_Amount,End_Time,Cycle_Image;

    public String getCycle_Image() {
        return Cycle_Image;
    }

    public void setCycle_Image(String cycle_Image) {
        Cycle_Image = cycle_Image;
    }

    public String getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(String end_Time) {
        End_Time = end_Time;
    }

    public bookingmodel() {
    }

    public bookingmodel(String date, String time, String cycle, String store, String accessory, String total_Amount,String end_time,String cycle_image) {
        Date = date;
        Time = time;
        Cycle = cycle;
        Store = store;
        Accessory = accessory;
        Total_Amount = total_Amount;
        End_Time=end_time;
        Cycle_Image=cycle_image;
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
