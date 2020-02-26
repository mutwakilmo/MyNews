package com.mutwakilmo.android.mynews;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements NetworkAsyncTask.Listeners,NYCallBack.Callbacks {

    // FOR DESIGN
    @BindView(R.id.fragment_main_textview)
    TextView textView;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    // -----------------
    // ACTIONS
    // -----------------

    @OnClick(R.id.fragment_main_button)
    public void submit(View view) {
        this.executeHttpRequest();

    }

    // ------------------------------
    //  HTTP REQUEST (Retrofit Way)
    // ------------------------------

    private void executeHttpRequestWithRetrofit(){
        this.updateUIWhenStartingHTTPRequest();
        NYCallBack.fetchNews(this, "title");
        new NetworkAsyncTask(this).execute("https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=FAPKrODFWcdFsvvfOBe8huf5SCc0NnBP");
    }


    // ------------------
    //  HTTP REQUEST
    // ------------------

    private void executeHttpRequest(){
        new NetworkAsyncTask(this).execute("https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=FAPKrODFWcdFsvvfOBe8huf5SCc0NnBP");
    }

    @Override
    public void onPreExecute() {
        this.updateUIWhenStartingHTTPRequest();

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(String json) {
        this.updateUIWhenStopingHTTPRequest(json);

    }

    // ------------------
    //  UPDATE UI
    // ------------------

    private void updateUIWhenStartingHTTPRequest(){
        this.textView.setText("Downloading...");
    }

    private void updateUIWhenStopingHTTPRequest(String response){
        this.textView.setText(response);
    }


    @Override
    public void onResponse(@Nullable List<Result> article) {

        if (article !=null) this.updateUIWithListOfUsers(article);

    }

    @Override
    public void onFailure() {
        this.updateUIWhenStopingHTTPRequest("An error happened !");

    }

    private void updateUIWithListOfUsers(List<Result> articles) {
        StringBuilder mStringBuilder = new StringBuilder();

            for (Result article : articles) {
                Log.e("TAG", "UPDATE UI" + article.getTitle());

                mStringBuilder.append("-" + article.getTitle() + "\n");
            }
            updateUIWhenStopingHTTPRequest(mStringBuilder.toString());
        }


    }