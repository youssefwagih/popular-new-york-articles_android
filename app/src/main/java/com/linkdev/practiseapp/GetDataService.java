package com.linkdev.practiseapp;

import com.linkdev.practiseapp.repository.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */


public interface GetDataService {

    @GET("/users/Google/repos")
    Call<List<Repo>> getAllPhotos();
}