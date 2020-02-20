package com.mutwakilmo.android.mynews;

import com.mutwakilmo.android.mynews.most_popular.MostPopular;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mutwakil Mo on 20/02/2020
 */

// -------------------------------------------------------------------------------------------------
// Explanations: This variable returns a Retrofit object that will then be used to run a network query.
//
//.baseUrl("https://api.nytimes.com/svc/")  : Used to define a root URL for Retrofi, used afterward as a
// base URL by our endpoints.
//
//.addConverterFactory(GsonConverterFactory.create()): Used to define the serializer/deserializer
// used by default by Retrofit, here GSON.
// -------------------------------------------------------------------------------------------------
public interface NewYorkTimesService {


    // Most Popular API
    @GET("mostpopular/v2/viewed/{period}.json")
    Call<List<MostPopular>> getMostPopular(
            @Path("period") int PERIOD,
            @Query("api-key") String API_KEY
    );


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


}

