package com.example.pedla;

public class model {
    String Name, Available_Cycles,Location;

    model(){

    }

    public model(String name, String available_Cycles, String location) {
        Name = name;
        Available_Cycles = available_Cycles;
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAvailable_Cycles() {
        return Available_Cycles;
    }

    public void setAvailable_Cycles(String available_Cycles) {
        Available_Cycles = available_Cycles;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
