package com.mutwakilmo.android.mynewsapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.muddzdev.styleabletoast.StyleableToast;
import com.mutwakilmo.android.mynewsapp.R;
import com.mutwakilmo.android.mynewsapp.Utils.InternetDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String LOG_TAG_WELCOME = WelcomeActivity.class.getSimpleName();

    @BindView(R.id.animation_view1)
    LottieAnimationView animationView1;
    @BindView(R.id.animation_view2)
    LottieAnimationView animationView2;
    @BindView(R.id.start_btn)
    LottieAnimationView startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Log.d(LOG_TAG_WELCOME, "onCreate");
        //Initialize ButterKnife
        ButterKnife.bind(this);
        // CALL getInternetStatus() function to check for internet and display error dialog
        if(new InternetDialog(this).getInternetStatus()){
            Toast.makeText(this, "MyNews Online\uD83D\uDCF6", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.start_btn)
    public void onViewClicked() {
        Log.d(LOG_TAG_WELCOME, "onViewClicked: Welcome start btn");
        //Toast.makeText(this, "welcome to MyNews app", Toast.LENGTH_SHORT).show();
        StyleableToast.makeText(this, "Welcome to MyNews app", R.style.mytoast).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    }

