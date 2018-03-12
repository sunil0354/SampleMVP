package com.app.sunilmvp.retrofit;

import com.app.sunilmvp.utils.ConstantsKey;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MY PC on 27-Dec-17.
 */

public class APIClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(ConstantsKey.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
    }
}
