package com.youssef.practiseapp.repository;

import android.arch.lifecycle.MutableLiveData;

import com.youssef.practiseapp.repository.model.ArticlesResponse;

import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public interface DataManager {
    MutableLiveData<ArticlesResponse> getArticlesItems(Callback<ArticlesResponse> callback);
}
