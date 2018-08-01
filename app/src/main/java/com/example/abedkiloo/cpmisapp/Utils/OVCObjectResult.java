package com.example.abedkiloo.cpmisapp.Utils;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class OVCObjectResult {


    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getHas_bcert() {
        return has_bcert;
    }

    public void setHas_bcert(String has_bcert) {
        this.has_bcert = has_bcert;
    }

    public String getIs_disabled() {
        return is_disabled;
    }

    public void setIs_disabled(String is_disabled) {
        this.is_disabled = is_disabled;
    }



    public String getSchool_level() {
        return school_level;
    }

    public void setSchool_level(String school_level) {
        this.school_level = school_level;
    }

    public String getImmunization_status() {
        return immunization_status;
    }

    public void setImmunization_status(String immunization_status) {
        this.immunization_status = immunization_status;
    }

    public String getOrg_unique_id() {
        return org_unique_id;
    }

    public void setOrg_unique_id(String org_unique_id) {
        this.org_unique_id = org_unique_id;
    }

    public String getExit_reason() {
        return exit_reason;
    }

    public void setExit_reason(String exit_reason) {
        this.exit_reason = exit_reason;
    }

    public String getExit_date() {
        return exit_date;
    }

    public void setExit_date(String exit_date) {
        this.exit_date = exit_date;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_void() {
        return is_void;
    }

    public void setIs_void(String is_void) {
        this.is_void = is_void;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    public String getChild_cbo() {
        return child_cbo;
    }

    public void setChild_cbo(String child_cbo) {
        this.child_cbo = child_cbo;
    }

    public String getChild_chv() {
        return child_chv;
    }

    public void setChild_chv(String child_chv) {
        this.child_chv = child_chv;
    }

    public String getArt_status() {
        return art_status;
    }

    public void setArt_status(String art_status) {
        this.art_status = art_status;
    }

    @SerializedName("person")
    private User person;
    @SerializedName("art_status")
    private String art_status;
    @SerializedName("id")
    private String id;
    @SerializedName("registration_date")
    private String registration_date;
    @SerializedName("has_bcert")
    private String has_bcert;
    @SerializedName("is_disabled")
    private String is_disabled;

    public String getHiv_status() {
        return hiv_status;
    }

    public void setHiv_status(String hiv_status) {
        this.hiv_status = hiv_status;
    }

    @SerializedName("hiv_status")
    private String hiv_status;
    @SerializedName("school_level")
    private String school_level;
    @SerializedName("immunization_status")
    private String immunization_status;
    @SerializedName("org_unique_id")
    private String org_unique_id;
    @SerializedName("exit_reason")
    private String exit_reason;
    @SerializedName("exit_date")
    private String exit_date;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("is_active")
    private String is_active;
    @SerializedName("is_void")
    private String is_void;
    @SerializedName("caretaker")
    private String caretaker;
    @SerializedName("child_cbo")
    private String child_cbo;
    @SerializedName("child_chv")
    private String child_chv;


}
