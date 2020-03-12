package com.mutwakilmo.android.mynews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.mutwakilmo.android.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    /*Todo App Overview todo*/

    //Todo 1 create splash launch Activity (lottie animation)
    //Todo 2 create welcome Activity

    //Todo 3 Main Fragment
    //Todo 4 Tab layout and viewPager

    //Todo 5 retrofit and NY apis (NewYorkTimes Service)
    //Todo 6 NY Models

    //Todo 7 Navigation drawer
    //Todo 8 Custom and design MyNews app logo and navigation drawer and tab fragment
    //Todo 9 ViewPager adapter and MostPopular adapter and TopStories adapter
    //Todo 10 Implement animation for the adapter while scroll
    //Todo Implement animation when I navigate through Activities
    //Todo 11 Download Google font
    //Todo 12 create SearchActivity
    //Todo 13 create AboutActivity
    //Todo 14 create HelpActivity
    //Todo 15 create NotificationActivity

    //Todo 16 Test MyNews app
    //Todo 17 Implement CircleCI (is a Leader in cloud-native continuous integration)

    //Todo 18 Support different ScreenSize
    //Todo SwipeRefreshLayout (Configure the SwipeRefreshLayout)
    //Todo  Implement Android Architecture Patterns  Model-View-Controller


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


        openWelcomeActivity();
    }

    /*Use handler to hold welcome activity UI for some time and
     then start the Welcome Activity*/

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
