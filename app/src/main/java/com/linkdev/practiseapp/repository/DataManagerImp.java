package com.linkdev.practiseapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.linkdev.practiseapp.network.RetrofitClientInstance;
import com.linkdev.practiseapp.repository.model.ArticlesResponse;
import com.linkdev.practiseapp.repository.remote.GetDataService;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class DataManagerImp implements DataManager {
    @Override
    public MutableLiveData<ArticlesResponse> getArticlesItems(Callback<ArticlesResponse> callback) {
        final MutableLiveData<ArticlesResponse> articlesResponseMutableLiveData = new MutableLiveData<>();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArticlesResponse> call = service.getArticlesItems();
        call.enqueue(callback);

        return articlesResponseMutableLiveData;
    }
}
