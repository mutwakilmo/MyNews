package com.mutwakilmo.android.mynews.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mutwakilmo.android.mynews.R;

import java.util.Objects;

public class SearchActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String TAG_LOG_SEARCH = SearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Log.d(TAG_LOG_SEARCH, "onCreate: ");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setActionBar(toolbar);

    }

    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
