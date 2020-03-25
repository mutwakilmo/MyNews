package com.mutwakilmo.android.mynews.Utils;

import com.mutwakilmo.android.mynews.Models.SearchNewYork.ArticleSearchResponse;
import com.mutwakilmo.android.mynews.Models.New_York_Times_Most_Popular.NYMostPopularResponse;
import com.mutwakilmo.android.mynews.Models.New_York_Times_Top_Stories.TopStoriesResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    String NEW_YORK_TIMES_URL = "https://api.nytimes.com/svc/";

    /*Ok HttpLoggingInterceptor*/

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(logging).build();



    //Retrofit Instance
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NEW_YORK_TIMES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();


    /*------------------------------------------------------------------------------
    |NY Times MostPopular API
    |@@GET("mostpopular/v2/viewed/{period}.json")
    |Used to indicate to Retrofit that we want to perform a REST request of the GET
    | @Path("period") int PERIOD,
    |As a parameter in our method getNYMostPopular(), we’re indicating a String variable
    |representing the parameter that Retrofit will place in the URL of the GET method
    |--------------------------------------------------------------------------------*/

    @GET("mostpopular/v2/viewed/{period}.json")
    Call<NYMostPopularResponse> getNYMostPopular(
            @Path("period") int PERIOD,
            @Query("api-key") String API_KEY
    );

    /*--------------------
    |NY Times Top Stories API
    |
    |---------------------*/

    @GET("topstories/v2/{section}.json")
    Call<TopStoriesResponse> getNYTopStories(
            @Path("section") String SECTION,
            @Query("api-key") String API_KEY
    );


     /*--------------------
    |
    |Article Search API
    |---------------------*/

  
    @GET("search/v2/articlesearch.json")
    Call<ArticleSearchResponse> getArticleSearch(
            @Query("q") String QUERY,
            @Query("fq") String FILTER,
            @Query("begin_date") String BEGIN_DATE,
            @Query("end_date") String END_DATE,
            @Query("api-key") String API_KEY
    );

}
