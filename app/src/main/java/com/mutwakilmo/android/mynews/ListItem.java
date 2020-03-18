package com.mutwakilmo.android.mynews;

import android.content.Context;

/**
 * Created by Mutwakil Mo on
 */
public class ListItem {


    String section;
    String subsection;
    String desc;
    String date;
    String urlImage;
    String urlWebsite;
    Context context;

    public String getSection() {
        return section;
    }

    public String getSubsection() {
        return subsection;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public String getUrlImage() { return urlImage; }

    public String getUrlWebsite() { return urlWebsite; }

    public ListItem(String section, String subsection, String desc, String date, String urlImage, String urlWebsite, Context context) {
        this.section = section;
        this.subsection = subsection;
        this.desc = desc;
        this.date = date;
        this.urlImage = urlImage;
        this.urlWebsite = urlWebsite;
        this.context = context;
    }
}
