package com.mutwakilmo.android.mynews;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;
import static com.mutwakilmo.android.mynews.Activities.NotificationsActivity.NY_PREFS_NAME;

/**
 * Created by Mutwakil Mo on
 */
public class NotificationsNewsReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE);

        final NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 200, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        ArrayList<String> categoriesCBSelected = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();

       // String searchQuery = sharedPreferences.getString("editTextNotifications")
        boolean isArtsChecked = sharedPreferences.getBoolean("isArtsChecked", false);
        boolean isPoliticsChecked = sharedPreferences.getBoolean("isPoliticsChecked", false);
        boolean isBusinessChecked = sharedPreferences.getBoolean("isBusinessChecked", false);
        boolean isSportsChecked = sharedPreferences.getBoolean("isSportsChecked", false);
        boolean isEntrepreneursChecked = sharedPreferences.getBoolean("isEntrepreneursChecked", false);
        boolean isTravelChecked = sharedPreferences.getBoolean("isTravelChecked", false);



    }
}
