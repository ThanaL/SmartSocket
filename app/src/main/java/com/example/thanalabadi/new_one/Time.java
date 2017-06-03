package com.example.thanalabadi.new_one;

/**
 * Created by thanalabadi on 3/23/2017.
 */

public class Time {
    public String mac;
    public  String name;
    public String check;
    public   String time;

    public Time(String name, String check, String time) {
        this.name = name;
        this.check = check;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
