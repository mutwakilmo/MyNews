package com.mutwakilmo.android.mynews;

/**
 * Created by Mutwakil Mo on 20/02/2020
 */
//These are the data we want to show in our recycler view
public interface NewsItem {

    String getTitle();

    String getPublished_date();

    String getImageUrl();

    String getUrl();

    String sectionAndSubsectionString();
}
