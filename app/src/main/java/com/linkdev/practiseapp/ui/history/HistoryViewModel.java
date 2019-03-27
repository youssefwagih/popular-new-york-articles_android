package com.linkdev.practiseapp.ui.history;

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

 public class HistoryViewModel extends AndroidViewModel {
    private DataManager dataManager = new DataManagerImp();
    MutableLiveData<List<Repo>> repos = new MutableLiveData<>();

    public HistoryViewModel(Application application) {
        super(application);
    }

    MutableLiveData<WeatherResponse> getCurrentWeatherData() {
        return  dataManager.getCurrentWeatherData();
    }
}
