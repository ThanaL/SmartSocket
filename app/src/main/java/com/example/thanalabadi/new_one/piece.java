package com.example.thanalabadi.new_one;

import java.util.List;

/**
 * Created by thanalabadi on 3/19/2017.
 */

public class piece {
    private String name;
    private String mac;
    private String state;
    public  List<Time> time_piece ;
    public List <String>users;

    public piece(String name, String mac, String state) {
        this.name = name;
        this.mac = mac;
        this.state = state;

    }
    public piece(String name, String mac, String state, List<Time> time_piece) {
        this.name = name;
        this.mac = mac;
        this.state = state;
        this.time_piece = time_piece;
    }



    public piece(String mac, List<Time> time_piece) {

        this.mac = mac;

        this.time_piece = time_piece;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Time> getTime_piece() {
        return time_piece;
    }

    public void setTime_piece(List<Time> time_piece) {
        this.time_piece = time_piece;
    }
}
