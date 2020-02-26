package com.mutwakilmo.android.mynews;

import java.util.List;

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

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Most Popular API
    @GET("mostpopular/v2/viewed/{period}.json")
    Call<List<Result>> getMostPopular(
            @Path("period") int PERIOD,
            @Query("api-key") String API_KEY
    );
}
