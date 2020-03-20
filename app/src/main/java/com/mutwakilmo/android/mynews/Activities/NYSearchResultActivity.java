package com.mutwakilmo.android.mynews.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mutwakilmo.android.mynews.Utils.ListItem;
import com.mutwakilmo.android.mynews.Models.SearchNewYork.ArticleSearchResponse;
import com.mutwakilmo.android.mynews.Adapter.NewsAdapter;
import com.mutwakilmo.android.mynews.R;
import com.mutwakilmo.android.mynews.Utils.NewYorkTimesService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NYSearchResultActivity extends AppCompatActivity {

    @BindView(R.id.noResultsTV)
    TextView noResultsTV;
    @BindView(R.id.search_recycler_view)
    RecyclerView searchRecyclerView;

    private NewsAdapter mAdapter;
    private List<ListItem> listItems;

    private NewYorkTimesService mNewYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_y_search_result);
        ButterKnife.bind(this);

        String searchQuery = "";
        String theBeginDateString = null;
        String theEndDateString = null;
        ArrayList<String> categoriesSelected = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            searchQuery = bundle.getString("searchQuery");
            theBeginDateString = bundle.getString("theBeginDateString");
            theEndDateString = bundle.getString("theEndDateString");
            categoriesSelected = bundle.getStringArrayList("categoriesSelected");
        }

        if (Objects.requireNonNull(searchQuery).equals("")) {
            noResultsTV.setText("Please enter a word in the search bar");
        } else {

            RecyclerView recyclerView = findViewById(R.id.search_recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(NYSearchResultActivity.this));
            listItems = new ArrayList<>();
            mAdapter = new NewsAdapter(listItems, NYSearchResultActivity.this);
            ;
            Call<ArticleSearchResponse> call;
            call = mNewYorkTimesService.getArticleSearch(searchQuery, Objects.requireNonNull(categoriesSelected).toString().replace("[", "").replace("]", ""), theBeginDateString, theEndDateString, "FAPKrODFWcdFsvvfOBe8huf5SCc0NnBP");
            Toast.makeText(this, searchQuery, Toast.LENGTH_SHORT).show();
            recyclerView.setAdapter(mAdapter);
            if (call != null) {
                call.enqueue(new Callback<ArticleSearchResponse>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(@NonNull Call<ArticleSearchResponse> call, @NonNull Response<ArticleSearchResponse> response) {
                        ArticleSearchResponse articles = response.body();
                        com.mutwakilmo.android.mynews.Models.SearchNewYork.Response theListOfArticles = Objects.requireNonNull(articles).getResponse();

                        if (theListOfArticles != null) {

                            for (int i = 0; i < theListOfArticles.getDocs().size(); i++) {

                                @SuppressLint("SimpleDateFormat") DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                @SuppressLint("SimpleDateFormat") DateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
                                String inputDateStr = theListOfArticles.getDocs().get(i).getPubDate();
                                if (inputDateStr == null) {
                                    inputDateStr = "";
                                }

                                Date date = null;
                                try {
                                    date = inputFormat.parse(inputDateStr);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                String outputDateStr = outputFormat.format(date);

                                if (theListOfArticles.getDocs().get(i).getMultimedia().size() != 0) {
                                    ListItem listItem = new ListItem("",
                                            "",
                                            theListOfArticles.getDocs().get(i).getSnippet(),
                                            outputDateStr,
                                            theListOfArticles.getDocs().get(i).getMultimedia().get(0).getUrl(),
                                            theListOfArticles.getDocs().get(i).getWebUrl(),
                                            NYSearchResultActivity.this);

                                    listItems.add(listItem);
                                } else {
                                    ListItem listItem = new ListItem("",
                                            "",
                                            theListOfArticles.getDocs().get(i).getSnippet(),
                                            outputDateStr,
                                            "".replace("https://", "http://"),
                                            theListOfArticles.getDocs().get(i).getWebUrl(),
                                            NYSearchResultActivity.this);
                                    listItems.add(listItem);

                                }
                            }
                        }
                        if (Objects.requireNonNull(theListOfArticles).getDocs().size() == 0) {
                            noResultsTV.setText("No articles matching your search. Try being less specific");
                        } else {
                            noResultsTV.setText("");
                        }
                        mAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleSearchResponse> call, @NonNull Throwable t) {

                        Log.d("JSON", t.getMessage());

                    }
                });
            }

        }
    }

}

