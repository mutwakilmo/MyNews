package com.mutwakilmo.android.mynewsapp.Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mutwakilmo.android.mynewsapp.R;
import com.mutwakilmo.android.mynewsapp.Utils.InternetDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {
    // Class name for Log tag
    public static final String TAG_LOG_SEARCH = SearchActivity.class.getSimpleName();
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editTextSearch)
    EditText editTextSearch;
    @BindView(R.id.linearLayoutDate)
    LinearLayout linearLayoutDate;
    @BindView(R.id.editTextBeginDate)
    EditText editTextBeginDate;
    @BindView(R.id.editTextEndDate)
    EditText editTextEndDate;
    @BindView(R.id.editTextLL)
    LinearLayout editTextLL;
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
    @BindView(R.id.searchButton)
    Button searchButton;

    private List<String> categoriesCBSelected = new ArrayList<>();
    final String[] beginDate = new String[1];
    final String[] theEndDate = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        Log.d(TAG_LOG_SEARCH, "onCreate: ");


        // CALL getInternetStatus() function to check for internet and display error dialog
        if (new InternetDialog(this).getInternetStatus()) {
            Toast.makeText(this, "MyNews Online\uD83D\uDCF6", Toast.LENGTH_SHORT).show();
        }

        setActionBar(toolbar);

        //Search edit text
        editTextSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    hideKeyboard(view);
                }
            }
        });


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

    @OnClick(R.id.searchButton)
    public void onViewClicked() {

        String searchQuery = editTextSearch.getText().toString();

        if (artsCB.isChecked()) {
            categoriesCBSelected.add("arts");
        }
        if (politicsCB.isChecked()) {
            categoriesCBSelected.add("politics");
        }
        if (businessCB.isChecked()) {
            categoriesCBSelected.add("business");
        }
        if (sportsCB.isChecked()) {
            categoriesCBSelected.add("sports");
        }
        if (entrepreneursCB.isChecked()) {
            categoriesCBSelected.add("entrepreneurs");
        }
        if (travelCB.isChecked()) {
            categoriesCBSelected.add("travel");
        }
        String theBeginDateString = beginDate[0];
        String theEndDateString = theEndDate[0];


        Intent myIntent = new Intent(SearchActivity.this, NYSearchResultActivity.class);
        myIntent.putExtra("searchQuery", searchQuery);
        myIntent.putExtra("categoriesSelected", (ArrayList) categoriesCBSelected);
        myIntent.putExtra("theBeginDateString", theBeginDateString);
        myIntent.putExtra("theEndDateString", theEndDateString);
        SearchActivity.this.startActivity(myIntent);

        categoriesCBSelected.clear();
    }


    // --------------------------------
    // DATE PICKER AND FORMAT TIME
    // -------------------------------

    final Calendar mCalendar = Calendar.getInstance();
    final DatePickerDialog.OnDateSetListener mOnBeginDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            formatTime();
        }

        private void formatTime() {
            String mFormat = "yyyyMMdd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mFormat, Locale.FRANCE);
            beginDate[0] = simpleDateFormat.format(mCalendar.getTime());

            String displayFormat = "MM/dd/yy";
            SimpleDateFormat simpleDisplayDateFormat = new SimpleDateFormat(displayFormat, Locale.FRANCE);
            editTextBeginDate.setText(simpleDisplayDateFormat.format(mCalendar.getTime()));
        }
    };

    final DatePickerDialog.OnDateSetListener mOnEndDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            formatTime();
        }


        //Todo format to local device time
        private void formatTime() {
            String mFormat = "yyyyMMdd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mFormat, Locale.FRANCE);
            theEndDate[0] = simpleDateFormat.format(mCalendar.getTime());

            String displayFormat = "MM/dd/yy";
            SimpleDateFormat simpleDisplayDateFormat = new SimpleDateFormat(displayFormat, Locale.FRANCE);
            editTextEndDate.setText(simpleDisplayDateFormat.format(mCalendar.getTime()));
        }
    };

    // --------------------------------
    //Search Begin Date Onclick TimePicker
    // -------------------------------
    @OnClick(R.id.editTextBeginDate)
    public void onEditTextBeginDateClicked() {
        new DatePickerDialog(SearchActivity.this, mOnBeginDateSetListener, mCalendar
                .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    // --------------------------------
    //End End Date Onclick TimePicker
    // -------------------------------
    @OnClick(R.id.editTextEndDate)
    public void onEditTextEndDateClicked() {
        new DatePickerDialog(SearchActivity.this, mOnEndDateSetListener, mCalendar
                .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    // --------------------------------
    // Hide Key board Methods
    // -------------------------------
    private void hideKeyboard(View rootView) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(inputMethodManager).hideSoftInputFromWindow(rootView.getWindowToken(), 0);
    }

}