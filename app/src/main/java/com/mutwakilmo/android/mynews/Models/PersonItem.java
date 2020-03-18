package com.mutwakilmo.android.mynews.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class PersonItem {
    @SerializedName("firstname")
    private String firstname;

    @SerializedName("role")
    private String role;

    @SerializedName("qualifier")
    private String qualifier;

    @SerializedName("organization")
    private String organization;

    @SerializedName("middlename")
    private String middlename;

    @SerializedName("rank")
    private int rank;

    @SerializedName("title")
    private String title;

    @SerializedName("lastname")
    private String lastname;

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public void setQualifier(String qualifier){
        this.qualifier = qualifier;
    }

    public String getQualifier(){
        return qualifier;
    }

    public void setOrganization(String organization){
        this.organization = organization;
    }

    public String getOrganization(){
        return organization;
    }

    public void setMiddlename(String middlename){
        this.middlename = middlename;
    }

    public String getMiddlename(){
        return middlename;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
        return lastname;
    }

    @Override
    public String toString(){
        return
                "PersonItem{" +
                        "firstname = '" + firstname + '\'' +
                        ",role = '" + role + '\'' +
                        ",qualifier = '" + qualifier + '\'' +
                        ",organization = '" + organization + '\'' +
                        ",middlename = '" + middlename + '\'' +
                        ",rank = '" + rank + '\'' +
                        ",title = '" + title + '\'' +
                        ",lastname = '" + lastname + '\'' +
                        "}";
    }
}
