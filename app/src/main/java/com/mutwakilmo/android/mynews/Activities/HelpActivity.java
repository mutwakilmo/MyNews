package com.mutwakilmo.android.mynews.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.airbnb.lottie.LottieAnimationView;
import com.mutwakilmo.android.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelpActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String TAG_LOG_HELP = HelpActivity.class.getSimpleName();
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView6)
    LottieAnimationView imageView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        //Initialize ButterKnife
        ButterKnife.bind(this);
        Log.d(TAG_LOG_HELP, "onCreate: ");


    }


    // return to Main Activity with slide animation
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
