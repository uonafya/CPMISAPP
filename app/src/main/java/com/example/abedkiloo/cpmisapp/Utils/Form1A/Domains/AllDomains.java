package com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AllDomains implements Serializable {


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<AllDomainsResuts> getResults() {
        return results;
    }

    public void setResults(List<AllDomainsResuts> results) {
        this.results = results;
    }

    @SerializedName("cunt")
    private int count;
    @SerializedName("next")
    private String next;
    @SerializedName("results")
    private List<AllDomainsResuts> results;
}
