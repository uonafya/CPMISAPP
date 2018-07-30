package com.example.abedkiloo.cpmisapp.Utils;

import com.google.gson.annotations.SerializedName;

public class CBOResult {

    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }

    public OrgUnit getOrg_unit() {
        return org_unit;
    }

    public void setOrg_unit(OrgUnit org_unit) {
        this.org_unit = org_unit;
    }

    @SerializedName("person")
    private User person;
    @SerializedName("org_unit")
    private  OrgUnit  org_unit;
}
