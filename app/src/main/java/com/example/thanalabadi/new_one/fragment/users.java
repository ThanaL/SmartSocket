package com.example.thanalabadi.new_one.fragment;

/**
 * Created by thanalabadi on 3/18/2017.
 */

public class users {
    private String email;
   private String [][] names;
   private String [][] updates;

    public users(String[][] names, String email, String[][] updates) {
        this.names = names;
        this.email = email;
        this.updates = updates;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNames(String[][] names) {
        this.names = names;
    }

    public void setUpdates(String[][] updates) {
        this.updates = updates;
    }

    public String getEmail() {
        return email;
    }

    public String[][] getNames() {
        return names;
    }

    public String[][] getUpdates() {
        return updates;
    }
}
