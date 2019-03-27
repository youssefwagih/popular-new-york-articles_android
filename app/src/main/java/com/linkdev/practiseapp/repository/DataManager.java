package com.linkdev.practiseapp.repository;

import android.arch.lifecycle.MutableLiveData;

import com.linkdev.practiseapp.repository.model.Repo;
import com.linkdev.practiseapp.repository.model.WeatherResponse;

import java.util.List;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public interface DataManager {
    MutableLiveData<WeatherResponse> getCurrentWeatherData();
}
