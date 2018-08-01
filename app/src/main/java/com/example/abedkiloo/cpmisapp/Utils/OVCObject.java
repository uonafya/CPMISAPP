package com.example.abedkiloo.cpmisapp.Utils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OVCObject {


    public List<OVCObjectResult> getResults() {
        return results;
    }

    public void setResults(List<OVCObjectResult> results) {
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
    private List<OVCObjectResult> results;
    @SerializedName("count")
    private String count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String prevous;

}
