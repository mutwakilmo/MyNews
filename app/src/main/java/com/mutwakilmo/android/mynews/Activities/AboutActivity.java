package com.mutwakilmo.android.mynews.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mutwakilmo.android.mynews.R;

public class AboutActivity extends AppCompatActivity {

    // Class name for Log tag
    public static final String LOG_TAG_ABOUT = AboutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.d(LOG_TAG_ABOUT, "onCreate: ");
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void onClickOpenWebpageButton(View view) {
        String urlAsString = "https://play.google.com/store/apps/dev?id=8103420999836613602&hl=en";
        openWebPage(urlAsString);
    }

    public void onClickOpenClassrooms(View view) {
        String oc = "https://openclassrooms.com/en/";
        openWebPage(oc);
    }

    public void onClickMyLinkedin(View view) {
        String linkedin = "https://www.linkedin.com/in/mutwakil-mo/";
        openWebPage(linkedin);
    }

    private void openWebPage(String url) {
        // Use Uri.parse to parse the String into a Uri
        /*
         * We wanted to demonstrate the Uri.parse method because its usage occurs frequently. You
         * could have just as easily passed in a Uri as the parameter of this method.
         */
        Uri webpage = Uri.parse(url);

        //  Create an Intent with Intent.ACTION_VIEW and the webpage Uri as parameters
        /*
         * Here, we create the Intent with the action of ACTION_VIEW. This action allows the user
         * to view particular content. In this case, our webpage URL.
         */
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //  Verify that this Intent can be launched and then call startActivity
        /*
         * This is a check we perform with every implicit Intent that we launch. In some cases,
         * the device where this code is running might not have an Activity to perform the action
         * with the data we've specified. Without this check, in those cases your app would crash.
         */
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
