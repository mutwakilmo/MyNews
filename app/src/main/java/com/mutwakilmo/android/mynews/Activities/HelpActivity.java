package com.mutwakilmo.android.mynews.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.mutwakilmo.android.mynews.R;

public class HelpActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String TAG_LOG_HELP = HelpActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Log.d(TAG_LOG_HELP, "onCreate: ");



    }


    // return to Main Activity with slide animation
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
