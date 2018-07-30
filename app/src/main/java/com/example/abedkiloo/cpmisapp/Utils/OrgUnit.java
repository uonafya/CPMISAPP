package com.example.abedkiloo.cpmisapp.Utils;

public class OrgUnit {
    public String getOrgUntName() {
        return OrgUntName;
    }

    public void setOrgUntName(String orgUntName) {
        OrgUntName = orgUntName;
    }

    public String getOrgUnitId() {
        return OrgUnitId;
    }

    public void setOrgUnitId(String orgUnitId) {
        OrgUnitId = orgUnitId;
    }

    public OrgUnit(String orgUnitName, String orgUnitId) {
        this.OrgUnitId = orgUnitId;
        this.OrgUntName = orgUnitName;
    }

    String OrgUntName;
    String OrgUnitId;
}
