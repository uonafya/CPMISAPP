package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.abedkiloo.cpmisapp.Utils.User;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "OVCs")
public class OVCs implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int local_ovc_id;
    @ColumnInfo(name = "person")
    private String person;
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "registration_date")
    private String registration_date;
    @ColumnInfo(name = "has_bcert")
    private String has_bcert;
    @ColumnInfo(name = "is_disabled")
    private String is_disabled;
    @ColumnInfo(name = "hiv_status")
    private String hiv_status;
    @ColumnInfo(name = "art_status")
    private String art_status;
    @ColumnInfo(name = "school_level")
    private String school_level;
    @ColumnInfo(name = "immunization_status")
    private String immunization_status;
    @ColumnInfo(name = "org_unique_id")
    private String org_unique_id;
    @ColumnInfo(name = "exit_reason")
    private String exit_reason;
    @ColumnInfo(name = "exit_date")
    private String exit_date;
    @ColumnInfo(name = "created_at")
    private String created_at;
    @ColumnInfo(name = "is_active")
    private String is_active;
    @ColumnInfo(name = "is_void")
    private String is_void;
    @ColumnInfo(name = "caretaker")
    private String caretaker;
    @ColumnInfo(name = "child_cbo")
    private String child_cbo;
    @ColumnInfo(name = "child_chv")
    private String child_chv;

    public int getLocal_ovc_id() {
        return local_ovc_id;
    }

    public void setLocal_ovc_id(int local_ovc_id) {
        this.local_ovc_id = local_ovc_id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
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

    public String getArt_status() {
        return art_status;
    }

    public void setArt_status(String art_status) {
        this.art_status = art_status;
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

    public String getHiv_status() {
        return hiv_status;
    }

    public void setHiv_status(String hiv_status) {
        this.hiv_status = hiv_status;
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
}
