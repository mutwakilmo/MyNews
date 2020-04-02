package com.mutwakilmo.android.mynewsapp.Models.SearchNewYork;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class Legacy {
    @SerializedName("widewidth")
    private int widewidth;

    @SerializedName("wideheight")
    private int wideheight;

    @SerializedName("wide")
    private String wide;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("thumbnailwidth")
    private int thumbnailwidth;

    @SerializedName("thumbnailheight")
    private int thumbnailheight;

    @SerializedName("xlarge")
    private String xlarge;

    @SerializedName("xlargewidth")
    private int xlargewidth;

    @SerializedName("xlargeheight")
    private int xlargeheight;

    public void setWidewidth(int widewidth){
        this.widewidth = widewidth;
    }

    public int getWidewidth(){
        return widewidth;
    }

    public void setWideheight(int wideheight){
        this.wideheight = wideheight;
    }

    public int getWideheight(){
        return wideheight;
    }

    public void setWide(String wide){
        this.wide = wide;
    }

    public String getWide(){
        return wide;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }

    public String getThumbnail(){
        return thumbnail;
    }

    public void setThumbnailwidth(int thumbnailwidth){
        this.thumbnailwidth = thumbnailwidth;
    }

    public int getThumbnailwidth(){
        return thumbnailwidth;
    }

    public void setThumbnailheight(int thumbnailheight){
        this.thumbnailheight = thumbnailheight;
    }

    public int getThumbnailheight(){
        return thumbnailheight;
    }

    public void setXlarge(String xlarge){
        this.xlarge = xlarge;
    }

    public String getXlarge(){
        return xlarge;
    }

    public void setXlargewidth(int xlargewidth){
        this.xlargewidth = xlargewidth;
    }

    public int getXlargewidth(){
        return xlargewidth;
    }

    public void setXlargeheight(int xlargeheight){
        this.xlargeheight = xlargeheight;
    }

    public int getXlargeheight(){
        return xlargeheight;
    }

    @Override
    public String toString(){
        return
                "Legacy{" +
                        "widewidth = '" + widewidth + '\'' +
                        ",wideheight = '" + wideheight + '\'' +
                        ",wide = '" + wide + '\'' +
                        ",thumbnail = '" + thumbnail + '\'' +
                        ",thumbnailwidth = '" + thumbnailwidth + '\'' +
                        ",thumbnailheight = '" + thumbnailheight + '\'' +
                        ",xlarge = '" + xlarge + '\'' +
                        ",xlargewidth = '" + xlargewidth + '\'' +
                        ",xlargeheight = '" + xlargeheight + '\'' +
                        "}";
    }
}
