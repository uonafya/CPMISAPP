package com.example.abedkiloo.cpmisapp.Utils.Form1A.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServiceObject {

    public List<ServiceObjectResult> getResults() {
        return results;
    }

    public void setResults(List<ServiceObjectResult> results) {
        this.results = results;
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

    @SerializedName("results")
    private List<ServiceObjectResult> results;
    @SerializedName("count")
    private String count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String prevous;

}
