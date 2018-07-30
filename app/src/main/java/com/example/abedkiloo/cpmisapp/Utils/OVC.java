package com.example.abedkiloo.cpmisapp.Utils;

public class OVC {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String name;
    public String location;

    public OVC(String name, String location) {
        this.location = location;
        this.name = name;
    }
}
