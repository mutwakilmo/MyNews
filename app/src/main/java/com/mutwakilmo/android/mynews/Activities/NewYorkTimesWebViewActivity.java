package com.mutwakilmo.android.mynews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.airbnb.lottie.LottieAnimationView;
import com.muddzdev.styleabletoast.StyleableToast;
import com.mutwakilmo.android.mynews.Utils.InternetDialog;
import com.mutwakilmo.android.mynews.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewYorkTimesWebViewActivity extends AppCompatActivity {
    private static final String TAG = NewYorkTimesWebViewActivity.class.getSimpleName();
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.imageView9)
    LottieAnimationView imageView9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_york_times_web_view);
        Log.i(TAG, "onCreate()");
        //Initialize ButterKnife
        ButterKnife.bind(this);

        // CALL getInternetStatus() function to check for internet and display error dialog
        if(new InternetDialog(this).getInternetStatus()){
            Toast.makeText(this, "MyNews Online\uD83D\uDCF6", Toast.LENGTH_SHORT).show();
        }



        setActionBar(toolbar);

        Intent myIntent = getIntent();
        String websiteUrl = Objects.requireNonNull(myIntent.getExtras()).getString("websiteUrl");
        // Toast.makeText(this, websiteUrl, Toast.LENGTH_LONG).show();
        StyleableToast.makeText(this, "Stay home it saves lives", R.style.mytoast).show();


        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(websiteUrl);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


        //------------------------------------------------------------------------------------
        //display current date using the Calendar class, how to format the date to the user’s
        // locale with the help of DateFormat and how to display it
        //------------------------------------------------------------------------------------


    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    // --------------------------------
    // slide animation back
    // -------------------------------
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
