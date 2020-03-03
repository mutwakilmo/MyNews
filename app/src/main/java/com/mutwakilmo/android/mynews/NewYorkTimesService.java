package com.mutwakilmo.android.mynews;

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


}
