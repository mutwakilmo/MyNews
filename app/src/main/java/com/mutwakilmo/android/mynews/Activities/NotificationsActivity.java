package com.mutwakilmo.android.mynews.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.mutwakilmo.android.mynews.R;

public class NotificationsActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String TAG_LOG_NOTIFICATIONS = NotificationsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Log.d(TAG_LOG_NOTIFICATIONS, "onCreate: ");
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

}
