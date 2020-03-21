package com.mutwakilmo.android.mynews.Utils;

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

import com.mutwakilmo.android.mynews.BuildConfig;
import com.mutwakilmo.android.mynews.Channel;
import com.mutwakilmo.android.mynews.Models.SearchNewYork.ArticleSearchResponse;
import com.mutwakilmo.android.mynews.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;
import static com.mutwakilmo.android.mynews.Activities.NotificationsActivity.NY_PREFS_NAME;


/**
 * Created by Mutwakil Mo on
 */
public class NotificationsNewsReceiver extends BroadcastReceiver {

    private NewYorkTimesService mNewYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE);


        final NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 200, intent, PendingIntent.FLAG_UPDATE_CURRENT);


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
                    com.mutwakilmo.android.mynews.Models.SearchNewYork.Response theListOfArticles = Objects.requireNonNull(articles).getResponse();
                    if (theListOfArticles.getDocs().size() != 0) {
                        if (Build.VERSION.SDK_INT <= 25) {
                            @SuppressLint("IconColors") NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                                    .setContentIntent(pendingIntent)
                                    .setSmallIcon(R.drawable.ic_bookmark_border_black_24dp)
                                    .setContentTitle("My News")
                                    .setContentText("Your articles of the day are ready")
                                    .setAutoCancel(true);
                            Objects.requireNonNull(notificationManager).notify(200, builder.build());
                        } else {

                            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, Channel.CHANNEL_1_ID)
                                    .setSmallIcon(R.drawable.ic_bookmark_border_black_24dp)
                                    .setContentTitle("My News")
                                    .setContentText("Your articles of the day are ready")
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
