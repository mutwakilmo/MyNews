package com.mutwakilmo.android.mynews.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mutwakilmo.android.mynews.Adapter.MostPopularAdapter;
import com.mutwakilmo.android.mynews.Adapter.TopStoriesAdapter;
import com.mutwakilmo.android.mynews.BuildConfig;
import com.mutwakilmo.android.mynews.New_York_Times_Most_Popular.NYMostPopularResponse;
import com.mutwakilmo.android.mynews.New_York_Times_Most_Popular.NYMostPopularResult;
import com.mutwakilmo.android.mynews.New_York_Times_Top_Stories.TopStoriesResponse;
import com.mutwakilmo.android.mynews.New_York_Times_Top_Stories.TopStoriesResultsItem;
import com.mutwakilmo.android.mynews.R;
import com.mutwakilmo.android.mynews.Utils.NYTConstants;
import com.mutwakilmo.android.mynews.Utils.NewYorkTimesService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // 1 - Declare the SwipeRefreshLayout
    @BindView(R.id.fragment_main_swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView myNewsRecyclerView;
    private TopStoriesAdapter mTopStoriesAdapter;
    private MostPopularAdapter mMostPopularAdapter;
    private List<NYMostPopularResult> mNYMostPopularResults = new ArrayList<>();
    private List<TopStoriesResultsItem> mTopStoriesResultsItems = new ArrayList<>();
    private NewYorkTimesService mNewYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String sectionName) {
        Bundle bundle = new Bundle();
        bundle.putString(NYTConstants.NYT_SECTION_NAME, sectionName);
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 4 - Configure the SwipeRefreshLayout

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTopStoriesAdapter = new TopStoriesAdapter(mTopStoriesResultsItems);
        mMostPopularAdapter = new MostPopularAdapter(mNYMostPopularResults);

        myNewsRecyclerView = view.findViewById(R.id.rv_news);
        myNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myNewsRecyclerView.setItemAnimator(new DefaultItemAnimator());


        if (getArguments() != null){
            String selectedSection = getArguments().getString(NYTConstants.NYT_SECTION_NAME, NYTConstants.NEWS_SECTIONS[0]);
            switch (selectedSection) {
                case "Most Popular":
                    myNewsRecyclerView.setAdapter(mMostPopularAdapter);
                    callMostPopular();
                    break;
                default:
                    myNewsRecyclerView.setAdapter(mTopStoriesAdapter);
                    callTopStories(selectedSection);
            }
        }
        return view;

    }






    public void callTopStories(String section) {
        Call<TopStoriesResponse> topStoriesResponseCall;
        switch (section) {
            case "Technology":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("technology", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Business":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("business", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Sport":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("sport", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Travel":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("travel", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Fashion":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("fashion", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Science":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("science", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Automobiles":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("automobiles", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Theatre":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("theatre", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Arts":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("arts", BuildConfig.MY_NYT_API_KEY);
                break;
            case "World":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("world", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Health":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("health", BuildConfig.MY_NYT_API_KEY);
                break;
            case "Food":
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("food", BuildConfig.MY_NYT_API_KEY);
                break;

            default:
                topStoriesResponseCall = mNewYorkTimesService.getNYTopStories("home", BuildConfig.MY_NYT_API_KEY);
        }

        topStoriesResponseCall.enqueue(new Callback<TopStoriesResponse>() {
            @Override
            public void onResponse(Call<TopStoriesResponse> call, Response<TopStoriesResponse> response) {
                if (response.body() != null) {
                    mTopStoriesResultsItems.addAll(response.body().getResults());
                    mTopStoriesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TopStoriesResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }

    public void callMostPopular() {
        Call<NYMostPopularResponse> nyMostPopularResponseCall = mNewYorkTimesService.getNYMostPopular(1, BuildConfig.MY_NYT_API_KEY);
        nyMostPopularResponseCall.enqueue(new Callback<NYMostPopularResponse>() {
            @Override
            public void onResponse(Call<NYMostPopularResponse> call, Response<NYMostPopularResponse> response) {
                if (response.body() != null) {
                    mNYMostPopularResults.clear();
                    mNYMostPopularResults.addAll(response.body().getResults());
                    mMostPopularAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NYMostPopularResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });


    }
}

