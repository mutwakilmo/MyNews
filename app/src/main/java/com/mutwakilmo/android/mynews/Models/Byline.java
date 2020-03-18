package com.mutwakilmo.android.mynews.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class Byline {
    @SerializedName("original")
    private String original;

    @SerializedName("person")
    private List<PersonItem> person;

    @SerializedName("organization")
    private String organization;

    public void setOriginal(String original){
        this.original = original;
    }

    public String getOriginal(){
        return original;
    }

    public void setPerson(List<PersonItem> person){
        this.person = person;
    }

    public List<PersonItem> getPerson(){
        return person;
    }

    public void setOrganization(String organization){
        this.organization = organization;
    }

    public String getOrganization(){
        return organization;
    }

    @Override
    public String toString(){
        return
                "Byline{" +
                        "original = '" + original + '\'' +
                        ",person = '" + person + '\'' +
                        ",organization = '" + organization + '\'' +
                        "}";
    }
}