package com.mutwakilmo.android.mynews.top_stories;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mutwakil Mo on
 */
public class TopStoriesResultsItem {

    @SerializedName("subsection")
    private String subsection;

    @SerializedName("section")
    private String section;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("multimedia")
    private List<MultimediaItem> multimedia;

    @SerializedName("published_date")
    private String publishedDate;

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MultimediaItem> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<MultimediaItem> multimedia) {
        this.multimedia = multimedia;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "TopStoriesResultsItem{" +
                "subsection='" + subsection + '\'' +
                ", section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", multimedia=" + multimedia +
                ", publishedDate='" + publishedDate + '\'' +
                '}';
    }
}