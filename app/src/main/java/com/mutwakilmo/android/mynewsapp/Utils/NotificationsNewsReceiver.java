package com.mutwakilmo.android.mynewsapp.Utils;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.mutwakilmo.android.mynewsapp.Activities.MainActivity;
import com.mutwakilmo.android.mynewsapp.BuildConfig;
import com.mutwakilmo.android.mynewsapp.Models.SearchNewYork.ArticleSearchResponse;
import com.mutwakilmo.android.mynewsapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;
import static android.content.Context.MODE_PRIVATE;
import static com.mutwakilmo.android.mynewsapp.Activities.NotificationsActivity.NY_PREFS_NAME;


/**
 * Created by Mutwakil Mo on
 */
public class NotificationsNewsReceiver extends BroadcastReceiver {

    private NewYorkTimesService mNewYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE);


        final NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent activityIntent = new Intent(context, MainActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 200, activityIntent, FLAG_UPDATE_CURRENT);


        ArrayList<String> categoriesCBSelected = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();


        String searchQuery = sharedPreferences.getString("editTextNotification", "");
        boolean isArtsChecked = sharedPreferences.getBoolean("isArtsChecked", false);
        boolean isPoliticsChecked = sharedPreferences.getBoolean("isPoliticsChecked", false);
        boolean isBusinessChecked = sharedPreferences.getBoolean("isBusinessChecked", false);
        boolean isSportsChecked = sharedPreferences.getBoolean("isSportsChecked", false);
        boolean isEntrepreneursChecked = sharedPreferences.getBoolean("isEntrepreneursChecked", false);
        boolean isTravelChecked = sharedPreferences.getBoolean("isTravelChecked", false);

        if (isArtsChecked) {
            categoriesCBSelected.add("arts");
        }
        if (isPoliticsChecked) {
            categoriesCBSelected.add("politics");
        }
        if (isBusinessChecked) {
            categoriesCBSelected.add("business");
        }
        if (isSportsChecked) {
            categoriesCBSelected.add("sports");
        }
        if (isEntrepreneursChecked) {
            categoriesCBSelected.add("entrepreneurs");
        }
        if (isTravelChecked) {
            categoriesCBSelected.add("travel");
        }

        Call<ArticleSearchResponse> call;
        call = mNewYorkTimesService.getArticleSearch(searchQuery, categoriesCBSelected.toString()
                        .replace("[", "").replace("]", ""),
                dateFormat.format(date), null, BuildConfig.MY_NYT_API_KEY);

        if (call != null) {
            call.enqueue(new Callback<ArticleSearchResponse>() {

                @SuppressWarnings("deprecation")
                @Override
                public void onResponse(@NonNull Call<ArticleSearchResponse> call, @NonNull Response<ArticleSearchResponse> response) {
                    ArticleSearchResponse articles = response.body();
                    com.mutwakilmo.android.mynewsapp.Models.SearchNewYork.Response theListOfArticles = Objects.requireNonNull(articles).getResponse();
                    if (theListOfArticles.getDocs().size() != 0) {
                        if (Build.VERSION.SDK_INT <= 25) {
                            @SuppressLint("IconColors") NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                                    .setContentIntent(pendingIntent)
                                    .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                                    .setContentTitle("MyNews")
                                    .setContentText("\uD83D\uDDFD Please don't forget to read your favourite article....")

                                    .setAutoCancel(true);

                            Objects.requireNonNull(notificationManager).notify(200, builder.build());
                        } else {

                            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, Channel.FAVOURITE_CONTENT)
                                    .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                                    .setContentTitle("MyNews")
                                    .setContentIntent(pendingIntent)
                                    .setContentText("\uD83D\uDDFD Please don't forget to read your favourite article....")
                                    .setOngoing(true);
                            notificationBuilder.build();
                            Objects.requireNonNull(notificationManager).notify(1, notificationBuilder.build());

                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ArticleSearchResponse> call, @NonNull Throwable t) {

                }
            });
        }




    }
}
