package com.mutwakilmo.android.mynewsapp.Models.SearchNewYork;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class MultimediaItem {
    @SerializedName("legacy")
    private Legacy legacy;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("crop_name")
    private String cropName;

    @SerializedName("width")
    private int width;

    @SerializedName("rank")
    private int rank;

    @SerializedName("caption")
    private String caption;

    @SerializedName("subType")
    private String subType;

    @SerializedName("credit")
    private String credit;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private int height;

    public void setLegacy(Legacy legacy){
        this.legacy = legacy;
    }

    public Legacy getLegacy(){
        return legacy;
    }

    public void setSubtype(String subtype){
        this.subtype = subtype;
    }

    public String getSubtype(){
        return subtype;
    }

    public void setCropName(String cropName){
        this.cropName = cropName;
    }

    public String getCropName(){
        return cropName;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    public void setCaption(String caption){
        this.caption = caption;
    }

    public String getCaption(){
        return caption;
    }

    public void setSubType(String subType){
        this.subType = subType;
    }

    public String getSubType(){
        return subType;
    }

    public void setCredit(String credit){
        this.credit = credit;
    }

    public String getCredit(){
        return credit;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    @Override
    public String toString(){
        return
                "MultimediaItem{" +
                        "legacy = '" + legacy + '\'' +
                        ",subtype = '" + subtype + '\'' +
                        ",crop_name = '" + cropName + '\'' +
                        ",width = '" + width + '\'' +
                        ",rank = '" + rank + '\'' +
                        ",caption = '" + caption + '\'' +
                        ",subType = '" + subType + '\'' +
                        ",credit = '" + credit + '\'' +
                        ",type = '" + type + '\'' +
                        ",url = '" + url + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
