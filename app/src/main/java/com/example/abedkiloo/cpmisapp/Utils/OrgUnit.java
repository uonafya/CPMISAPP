package com.example.abedkiloo.cpmisapp.Utils;

import com.google.gson.annotations.SerializedName;

public class OrgUnit {
    public String getOrgUntName() {
        return org_unit_name;
    }

    public void setOrgUntName(String orgUntName) {
        org_unit_name = orgUntName;
    }

    public String getOrgUnitId() {
        return id;
    }

    public void setOrgUnitId(String orgUnitId) {
        id = orgUnitId;
    }

    public OrgUnit(String orgUnitName, String orgUnitId) {
        this.id = orgUnitId;
        this.org_unit_name = orgUnitName;
    }

    public OrgUnit() {

    }

    @SerializedName("org_unit_name")
    String org_unit_name;
    @SerializedName("id")
    String id;

    public String getOrg_unit_name() {
        return org_unit_name;
    }

    public void setOrg_unit_name(String org_unit_name) {
        this.org_unit_name = org_unit_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrg_unit_id_vis() {
        return org_unit_id_vis;
    }

    public void setOrg_unit_id_vis(String org_unit_id_vis) {
        this.org_unit_id_vis = org_unit_id_vis;
    }

    public String getOrg_unit_type_id() {
        return org_unit_type_id;
    }

    public void setOrg_unit_type_id(String org_unit_type_id) {
        this.org_unit_type_id = org_unit_type_id;
    }

    public String getDate_operational() {
        return date_operational;
    }

    public void setDate_operational(String date_operational) {
        this.date_operational = date_operational;
    }

    public String getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(String date_closed) {
        this.date_closed = date_closed;
    }

    public String getHandle_ovc() {
        return handle_ovc;
    }

    public void setHandle_ovc(String handle_ovc) {
        this.handle_ovc = handle_ovc;
    }

    public String getIs_void() {
        return is_void;
    }

    public void setIs_void(String is_void) {
        this.is_void = is_void;
    }

    public String getParent_org_unit_id() {
        return parent_org_unit_id;
    }

    public void setParent_org_unit_id(String parent_org_unit_id) {
        this.parent_org_unit_id = parent_org_unit_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @SerializedName("org_unit_id_vis")
    String org_unit_id_vis;
    @SerializedName("org_unit_type_id")
    String org_unit_type_id;
    @SerializedName("date_operational")
    String date_operational;
    @SerializedName("date_closed")
    String date_closed;
    @SerializedName("handle_ovc")
    String handle_ovc;
    @SerializedName("is_void")
    String is_void;
    @SerializedName("parent_org_unit_id")
    String parent_org_unit_id;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("created_by")
    String created_by;
}
