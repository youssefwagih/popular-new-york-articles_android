package com.linkdev.practiseapp.ui.Weather;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.linkdev.practiseapp.repository.DataManager;
import com.linkdev.practiseapp.repository.DataManagerImp;
import com.linkdev.practiseapp.repository.model.Repo;
import com.linkdev.practiseapp.repository.model.WeatherResponse;

import java.util.List;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

 public class WeatherViewModel extends AndroidViewModel {
    private DataManager dataManager = new DataManagerImp();
    MutableLiveData<List<Repo>> repos = new MutableLiveData<>();

    public WeatherViewModel(Application application) {
        super(application);
    }

    MutableLiveData<WeatherResponse> getCurrentWeatherData() {
        return  dataManager.getCurrentWeatherData();
    }
}
