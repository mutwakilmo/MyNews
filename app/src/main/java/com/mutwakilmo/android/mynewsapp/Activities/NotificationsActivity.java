package com.mutwakilmo.android.mynewsapp.Activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationManagerCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.muddzdev.styleabletoast.StyleableToast;
import com.mutwakilmo.android.mynewsapp.R;
import com.mutwakilmo.android.mynewsapp.Utils.InternetDialog;
import com.mutwakilmo.android.mynewsapp.Utils.NotificationsNewsReceiver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener {

    private NotificationManagerCompat mNotificationManagerCompat;
    // Class name for Log tag
    public static final String TAG_LOG_NOTIFICATIONS = NotificationsActivity.class.getSimpleName();
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editTextSearchNotification)
    EditText editTextSearchNotification;
    @BindView(R.id.artsCB)
    CheckBox artsCB;
    @BindView(R.id.politicsCB)
    CheckBox politicsCB;
    @BindView(R.id.checkboxLL1)
    LinearLayout checkboxLL1;
    @BindView(R.id.businessCB)
    CheckBox businessCB;
    @BindView(R.id.sportsCB)
    CheckBox sportsCB;
    @BindView(R.id.checkboxLL2)
    LinearLayout checkboxLL2;
    @BindView(R.id.entrepreneursCB)
    CheckBox entrepreneursCB;
    @BindView(R.id.travelCB)
    CheckBox travelCB;
    @BindView(R.id.checkboxLL3)
    LinearLayout checkboxLL3;
    @BindView(R.id.theLine)
    TextView theLine;
    @BindView(R.id.oncePerDay)
    TextView oncePerDay;
    @BindView(R.id.notificationSwitch)
    Switch notificationSwitch;
    @BindView(R.id.imageView3)
    LottieAnimationView imageView3;

    public static final String NY_PREFS_NAME = "NotificationsFile";
    private List<String> categoriesBeSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);
        Log.d(TAG_LOG_NOTIFICATIONS, "onCreate: ");


        final SharedPreferences.Editor editor = getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE).edit();
        SharedPreferences sharedPreferences = getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE);

        final boolean isChecked = sharedPreferences.getBoolean("isChecked", false);
        boolean isArtsChecked = sharedPreferences.getBoolean("isArtsChecked", false);
        boolean isPoliticsChecked = sharedPreferences.getBoolean("isPoliticsChecked", false);
        boolean isBusinessChecked = sharedPreferences.getBoolean("isBusinessChecked", false);
        boolean isSportsChecked = sharedPreferences.getBoolean("isSportsChecked", false);
        boolean isEntrepreneursChecked = sharedPreferences.getBoolean("isEntrepreneursChecked", false);
        boolean isTravelChecked = sharedPreferences.getBoolean("isTravelChecked", false);



        // --------------------------------
        // SharedPref
        // -------------------------------
        editTextSearchNotification.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("editTextNotification", editTextSearchNotification.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("textNotifications", editTextSearchNotification.getText().toString());
                editor.apply();

            }
        });

        String editTextValue = sharedPreferences.getString("editTextNotification", "");
        editTextSearchNotification.setText(editTextValue);

        /*-------------artsCB-----------------*/
        artsCB.setChecked(isArtsChecked);
        artsCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("isArtsChecked", b);
                editor.apply();
            }
        });

        /*-------------politicsCB-----------------*/
        politicsCB.setChecked(isPoliticsChecked);
        politicsCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("isPoliticsChecked", b);
                editor.apply();
            }
        });

        /*-------------sportsCB-----------------*/
        sportsCB.setChecked(isSportsChecked);
        sportsCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("isSportsChecked", b);
                editor.apply();
            }
        });

        /*-------------businessCB-----------------*/
        businessCB.setChecked(isBusinessChecked);
        businessCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("isBusinessChecked", b);
                editor.apply();
            }
        });

        /*-------------entrepreneursCB-----------------*/
        entrepreneursCB.setChecked(isEntrepreneursChecked);
        entrepreneursCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("isEntrepreneursChecked", b);
                editor.apply();
            }
        });

        /*-------------travelCB-----------------*/
        travelCB.setChecked(isTravelChecked);
        travelCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("isTravelChecked", b);
                editor.apply();
            }
        });



        /*-------------notificationSwitch-----------------*/

        if (notificationSwitch != null) {
            notificationSwitch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
            notificationSwitch.setChecked(isChecked);
        }
        /*-------------SettingNotification-----------------*/
        if (isChecked) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            /*-------------AlarmManager-----------------*/

            Intent intent = new Intent(getApplicationContext(), NotificationsNewsReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                    Integer.parseInt("200"), intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            assert alarmManager != null;
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_HALF_HOUR, pendingIntent);




        }


        // ---------------------------------------------------------------------------------
        // CALL getInternetStatus() function to check for internet and display error dialog
        // -------------------------------------------------------------------------------

        if (new InternetDialog(this).getInternetStatus()) {
            Toast.makeText(this, "MyNews Online\uD83D\uDCF6", Toast.LENGTH_SHORT).show();
        }
        setActionBar(toolbar);
    }


    // --------------------------------
    //Action Bar
    // -------------------------------
    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // --------------------------------
    // SharedPref
    // -------------------------------
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        StyleableToast.makeText(this, "Notifications  " + (isChecked ? "On" : "Off"), R.style.mytoast).show();

        SharedPreferences.Editor editor = getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean("isChecked", isChecked);
        editor.apply();


    }

    // --------------------------------
    // Back animations
    // -------------------------------
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
