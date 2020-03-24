package com.mutwakilmo.android.mynews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.mutwakilmo.android.mynews.Utils.InternetDialog;
import com.mutwakilmo.android.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {


    // Class name for Log tag
    public static final String LOG_TAG_SPLASH = SplashActivity.class.getSimpleName();
    //Duration of wait
    private final int SPLASH_DISPLAY_LENGHT = 8000;
    @BindView(R.id.animation_view)
    LottieAnimationView animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Initialize ButterKnife
        ButterKnife.bind(this);
        // Log the start of the onCreate() method
        Log.d(LOG_TAG_SPLASH, "onCreate");

        // CALL getInternetStatus() function to check for internet and display error dialog
        if (new InternetDialog(this).getInternetStatus()) {
            Toast.makeText(this, "MyNews Online\uD83D\uDCF6", Toast.LENGTH_SHORT).show();
        }


        openWelcomeActivity();
    }

    //-------------------------------------------------------------
    //Use handler to hold welcome activity UI for some time and
    // then start the Welcome Activity
    //------------------------------------------------------------

    private void openWelcomeActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
