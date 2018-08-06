package com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains;

import com.google.gson.annotations.SerializedName;

public class Payload {
    @SerializedName("payload")
    private DomainPayload domainPayload;

    public DomainPayload getDomainPayload() {
        return domainPayload;
    }

    public void setDomainPayload(DomainPayload domainPayload) {
        this.domainPayload = domainPayload;
    }
}
