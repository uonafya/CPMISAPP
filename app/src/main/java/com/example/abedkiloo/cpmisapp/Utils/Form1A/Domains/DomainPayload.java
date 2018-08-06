package com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains;

import com.google.gson.annotations.SerializedName;

public class DomainPayload {
    public DomainPayload(String domain, int index) {
        this.domain_id = domain;
        this.index = index;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @SerializedName("domain_id")
    String domain_id;
    @SerializedName("index")
    int index;
}
