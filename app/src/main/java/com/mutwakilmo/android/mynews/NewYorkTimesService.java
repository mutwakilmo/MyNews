package com.mutwakilmo.android.mynews;

import com.mutwakilmo.android.mynews.MostPoular.MostPopularAPIs;
import com.mutwakilmo.android.mynews.TopStories.NYTimesTopStories;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mutwakil Mo on 22/02/2020
 */
public interface NewYorkTimesService {
    // -------------------------------------------------------------------------------------
    // Explanations: This variable returns a Retrofit object that will then be used to run a network query.
    //.baseUrl("https://api.nytimes.com/svc/")  : Used to define a root URL for Retrofi, used afterward as a
    // base URL by our endpoints.
    //.addConverterFactory(GsonConverterFactory.create()): Used to define the serializer/deserializer
    // used by default by Retrofit, here GSON.
    // -------------------------------------------------------------------------------------

    //Base URL from the NewYorkTimes APIs
    String NEWYORKTIMES_URL = "https://api.nytimes.com/svc/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Most Popular API
    @GET("mostpopular/v2/viewed/{period}.json")
    Call<MostPopularAPIs> getMostPopular(
            @Path("period") int PERIOD,
            @Query("api-key") String API_KEY
    );

    // Top Stories API
    @GET("topstories/v2/{section}.json")
    Call<NYTimesTopStories> getTopStories(
            @Path("section") String SECTION,
            @Query("api-key") String API_KEY
    );

}
