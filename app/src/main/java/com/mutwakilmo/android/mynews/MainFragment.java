package com.mutwakilmo.android.mynews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mutwakilmo.android.mynews.MostPoular.MostPopularResult;
import com.mutwakilmo.android.mynews.TopStories.TobStoriesResult;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.*/


public class MainFragment extends Fragment {

    private RecyclerView newsRecyclerView;

    private TopStoriesAdapter topStoriesAdapter;
    private MostPopularAdapter mostPopularAdapter;

    private List<TobStoriesResult> topStoriesResultsItems = new ArrayList<>();
    private List<MostPopularResult> mostPopularResultsItems = new ArrayList<>();
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
     * @return A new instance of fragment MainFragment.*/


    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String newsSections) {
        Bundle bundle = new Bundle();
        bundle.putString(NYTConstants.NYT_SECTION_NAME, newsSections);
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        topStoriesAdapter = new TopStoriesAdapter(topStoriesResultsItems);
        mostPopularAdapter = new MostPopularAdapter(mostPopularResultsItems);

        newsRecyclerView = view.findViewById(R.id.rv_news);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecyclerView.setItemAnimator(new DefaultItemAnimator());


        if (getArguments() != null) {
            String selectedSection = getArguments().getString(NYTConstants.NYT_SECTION_NAME, NYTConstants.NEWS_SECTIONS[0]);
            switch (selectedSection) {
                case "Most Popular":
                    newsRecyclerView.setAdapter(mostPopularAdapter);
                    callMostPopularNews();
                    break;
                default:
                    newsRecyclerView.setAdapter(topStoriesAdapter);
                    callTopStoriesNews(selectedSection);
            }
        }

        return view;
    }

    private void callMostPopularNews() {

    }

    private void  callTopStoriesNews(String selectedSection){


    }
}
