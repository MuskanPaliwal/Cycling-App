package com.example.pedla;

public class modelone {
    String Cycle_Name, Amount,Cycle_Image;

    public String getCycle_Image() {
        return Cycle_Image;
    }

    public void setCycle_Image(String cycle_Image) {
        Cycle_Image = cycle_Image;
    }

    modelone(){

    }

    public modelone(String cycle_Name, String amount,String cycle_image) {
        Cycle_Name = cycle_Name;
        Amount = amount;
        Cycle_Image=cycle_image;
    }

    public String getCycle_Name() {
        return Cycle_Name;
    }

    public void setCycle_Name(String cycle_Name) {
        Cycle_Name = cycle_Name;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
