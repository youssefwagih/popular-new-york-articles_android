package com.linkdev.practiseapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.linkdev.practiseapp.network.RetrofitClientInstance;
import com.linkdev.practiseapp.repository.model.Repo;
import com.linkdev.practiseapp.repository.model.WeatherResponse;
import com.linkdev.practiseapp.repository.remote.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class DataManagerImp implements DataManager {
    public MutableLiveData<List<Repo>> getAllRepos() {
        final MutableLiveData<List<Repo>> repos = new MutableLiveData<>();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Repo>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, retrofit2.Response<List<Repo>> response) {
                repos.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
            }
        });

        return repos;
    }

    @Override
    public MutableLiveData<WeatherResponse> getCurrentWeatherData() {
        final MutableLiveData<WeatherResponse> weatherResponseMutableLiveData = new MutableLiveData<>();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<WeatherResponse> call = service.getCurrentWeatherData();
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {
                weatherResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("", "");
            }
        });

        return weatherResponseMutableLiveData;
    }
}
