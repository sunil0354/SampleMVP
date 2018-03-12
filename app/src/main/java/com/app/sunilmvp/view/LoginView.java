package com.app.sunilmvp.view;

import com.app.sunilmvp.model.Model;

public interface LoginView  {
    //hitting API
    void onFetchStart();
    void onFetchProgress(Model model);
    void onFetchComplete(int i);
    void onFetchFailed();
}
