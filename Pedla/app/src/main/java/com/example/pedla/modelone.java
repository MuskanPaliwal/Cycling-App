package com.example.pedla;

public class modelone {
    String Cycle_Name, Amount;

    modelone(){

    }

    public modelone(String cycle_Name, String amount) {
        Cycle_Name = cycle_Name;
        Amount = amount;
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
