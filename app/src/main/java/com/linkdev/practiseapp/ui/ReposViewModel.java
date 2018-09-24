package com.linkdev.practiseapp.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.linkdev.practiseapp.GetDataService;
import com.linkdev.practiseapp.network.RetrofitClientInstance;
import com.linkdev.practiseapp.repository.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class ReposViewModel extends AndroidViewModel {
    MutableLiveData<List<Repo>> repos = new MutableLiveData<>();

    public ReposViewModel(Application application) {
        super(application);
    }

    MutableLiveData<List<Repo>> getRepos() {
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
}
