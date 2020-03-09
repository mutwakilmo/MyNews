package com.mutwakilmo.android.mynews;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import static android.R.id.home;

public class NewYorkTimesWebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_york_times_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setActionBar(toolbar);

        Intent myIntent = getIntent();
        String websiteUrl = Objects.requireNonNull(myIntent.getExtras()).getString("websiteUrl");
        // Toast.makeText(this, websiteUrl, Toast.LENGTH_LONG).show();



        mWebView = findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(websiteUrl);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case home: finish();
        }
        return true;
    }

    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
