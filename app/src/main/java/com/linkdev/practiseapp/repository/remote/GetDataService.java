package com.linkdev.practiseapp.repository.remote;

import com.linkdev.practiseapp.repository.model.ArticlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */


public interface GetDataService {

    @GET("/svc/mostpopular//v2/viewed/1.json?api-key=IsDnmgfMSOpuJZnkqsnlJHeEAZnwzpvV")
    Call<ArticlesResponse> getArticlesItems();
}