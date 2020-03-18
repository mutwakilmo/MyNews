package com.mutwakilmo.android.mynews.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class Headline {
    @SerializedName("sub")
    private String sub;

    @SerializedName("content_kicker")
    private String contentKicker;

    @SerializedName("name")
    private String name;

    @SerializedName("main")
    private String main;

    @SerializedName("seo")
    private String seo;

    @SerializedName("print_headline")
    private String printHeadline;

    @SerializedName("kicker")
    private String kicker;

    public void setSub(String sub){
        this.sub = sub;
    }

    public String getSub(){
        return sub;
    }

    public void setContentKicker(String contentKicker){
        this.contentKicker = contentKicker;
    }

    public String getContentKicker(){
        return contentKicker;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setMain(String main){
        this.main = main;
    }

    public String getMain(){
        return main;
    }

    public void setSeo(String seo){
        this.seo = seo;
    }

    public String getSeo(){
        return seo;
    }

    public void setPrintHeadline(String printHeadline){
        this.printHeadline = printHeadline;
    }

    public String getPrintHeadline(){
        return printHeadline;
    }

    public void setKicker(String kicker){
        this.kicker = kicker;
    }

    public String getKicker(){
        return kicker;
    }

    @Override
    public String toString(){
        return
                "Headline{" +
                        "sub = '" + sub + '\'' +
                        ",content_kicker = '" + contentKicker + '\'' +
                        ",name = '" + name + '\'' +
                        ",main = '" + main + '\'' +
                        ",seo = '" + seo + '\'' +
                        ",print_headline = '" + printHeadline + '\'' +
                        ",kicker = '" + kicker + '\'' +
                        "}";
    }
}
