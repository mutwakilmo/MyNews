package com.mutwakilmo.android.mynewsapp.Models.SearchNewYork;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class KeywordsItem {
    @SerializedName("major")
    private String major;

    @SerializedName("name")
    private String name;

    @SerializedName("rank")
    private int rank;

    @SerializedName("value")
    private String value;

    public void setMajor(String major){
        this.major = major;
    }

    public String getMajor(){
        return major;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return
                "KeywordsItem{" +
                        "major = '" + major + '\'' +
                        ",name = '" + name + '\'' +
                        ",rank = '" + rank + '\'' +
                        ",value = '" + value + '\'' +
                        "}";
    }
}

