package com.mutwakilmo.android.mynews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.mutwakilmo.android.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String LOG_TAG = WelcomeActivity.class.getSimpleName();

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
        Log.d(LOG_TAG, "onCreate");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_btn)
    public void onViewClicked() {
        Log.d(LOG_TAG, "onViewClicked: Welcome start btn");
        Toast.makeText(this, "welcome to MyNews app", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}
