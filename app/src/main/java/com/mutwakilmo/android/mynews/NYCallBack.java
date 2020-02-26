package com.mutwakilmo.android.mynews;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mutwakil Mo on 22/02/2020
 */
public class NYCallBack {

    // 1 - Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable List<Result> article);
        void onFailure();
    }

    // 2 - Public method to start fetching users following by Jake Wharton
    public static void fetchNews(Callbacks callbacks, String article){

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        NewYorkTimesService newYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);

// 2.3 - Create the call on Github API
        Call<List<Result>> call = (Call<List<Result>>) newYorkTimesService;
        // 2.4 - Start the call
        call.enqueue(new Callback<List<Result>>() {

            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
