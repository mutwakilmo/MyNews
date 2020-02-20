/*
package com.mutwakilmo.android.mynews;

import androidx.annotation.Nullable;

import com.mutwakilmo.android.mynews.most_popular.MostPopular;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

*/
/**
 * Created by Mutwakil Mo on 20/02/2020
 *//*

public class NewYorkCalls {
    // 1 - Creating a callback
    public interface Callbacks{
        void onResponse(@Nullable List<MostPopular> mostPopulars);
        void onFailure(Throwable e);
    }

    //2- Public methode to start fetching MostPopulars
    public static final void fetchMostPopular(Callbacks callbacks, String articles) {

    }


    // Create a weak reference to callback (avoid memory leaks)
    final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

    // Get a Retrofit instance and the related endpoints
    NewYorkTimesService mNewYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);

    // Create the call on Github API
    Call<List<MostPopular>> call = mNewYorkTimesService.getMostPopular(username);
    // Start the call
        call.enqueue(new Callbacks<List<MostPopular>>() {

        @Override
        public void onResponse(Call<List<MostPopular>> call, Response <List<MostPopular>> onResponse) {
            // Call the proper callback used in controller (MainFragment)
            if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(onResponse.body());
        }

        @Override
        public void onFailure(Call<List<MostPopular>> call, Throwable ) {
            // Call the proper callback used in controller (MainFragment)
            if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
        }
    });
}
}
*/
