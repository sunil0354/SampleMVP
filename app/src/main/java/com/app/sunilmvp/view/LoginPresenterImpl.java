package com.app.sunilmvp.view;

import android.support.annotation.NonNull;
import android.util.Log;

import com.app.sunilmvp.model.Model;
import com.app.sunilmvp.retrofit.APIClient;
import com.app.sunilmvp.retrofit.APIInterface;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView mView;

    LoginPresenterImpl(LoginView view) {
        this.mView=view;        //assigning LoginView to this view
    }

    @Override
    public void onLogin() {
        mView.onFetchStart();
        HashMap<String, String> hashMap = new HashMap<>();
        Log.e("TAG", "Data Send>>>\n"+hashMap.toString());
        Call<Object> call = APIClient.getClient().create(APIInterface.class).baseurl();
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                JSONObject object= null;
                try {
                    object = new JSONObject(new Gson().toJson(response.body()));
                    Log.e("TAG", "Data get>>>\n: "+object );
                    int result_code=object.getInt("result_code");
                    switch (result_code){
                        case 1:
                            JSONArray jsonArray=object.getJSONArray("result_data");
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                Model model=new Model();
                                mView.onFetchProgress(model);
                            }
                            break;
                    }
                    mView.onFetchComplete(result_code);
                } catch (Exception exception) {
                    Log.e("TAG", "Exception>>>\n: "+exception );
                    mView.onFetchFailed();
                }
            }
            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                call.cancel();
                Log.e("TAG", "Failure>>>\n: "+t );
                mView.onFetchFailed();
            }
        });
    }
}
