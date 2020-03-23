package com.mutwakilmo.android.mynews;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * Created by Mutwakil Mo on
 */
public class Channel  extends Application {

    //in real app you give it a name for ...
    public static final String FAVOURITE_CONTENT = "favouriteContent";
    public static final String BREAKING_NEWS = "breaking_news";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        //the notification is not available in lower version
        //for orio
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel favourite_content = new NotificationChannel(
                    FAVOURITE_CONTENT,
                    "Favourite Content",
                    //constant define how the notification behave
                    NotificationManager.IMPORTANCE_HIGH
            );
            favourite_content.setDescription("This is Chanel 1");

            NotificationChannel breaking_news = new NotificationChannel(
                    BREAKING_NEWS,
                    "Breaking News",
                    NotificationManager.IMPORTANCE_LOW
            );
            breaking_news.setDescription("This channel is 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(favourite_content);
            manager.createNotificationChannel(breaking_news);
        }
    }
}
