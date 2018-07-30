package com.example.abedkiloo.cpmisapp.Utils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @SerializedName("token")
    private String token;
    @SerializedName("username")
    private String username;

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

    @SerializedName("password")
    private String password;
    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevous() {
        return prevous;
    }

    public void setPrevous(String prevous) {
        this.prevous = prevous;
    }


    public List<CBOResult> getResults() {
        return results;
    }

    public void setResults(List<CBOResult> results) {
        this.results = results;
    }

    @SerializedName("results")
    private List<CBOResult> results;
    @SerializedName("count")
    private String count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String prevous;

}
