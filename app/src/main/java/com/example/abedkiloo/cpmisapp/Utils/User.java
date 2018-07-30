package com.example.abedkiloo.cpmisapp.Utils;

public class User {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     String username;
     String password;
     String id;
     String designation;
     String first_name;
     String other_names;
     String surname;
     String email;
     String des_phone_number;
     String date_of_birth;
     String date_of_death;
     String sex_id;
     String is_void;
     String created_at;
     String created_by;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
