package com.linkdev.practiseapp.ui.articles;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.linkdev.practiseapp.R;
import com.linkdev.practiseapp.repository.DataManager;
import com.linkdev.practiseapp.repository.DataManagerImp;
import com.linkdev.practiseapp.repository.model.ArticlesResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

 public class ArticlesViewModel extends ViewModel {
    private DataManager dataManager = new DataManagerImp();

    private final MutableLiveData<ArticlesResponse> articlesResponseMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private final MutableLiveData<Boolean> errorMutableLiveData = new MutableLiveData<>();

    public ArticlesViewModel() {
        super();
        fetchArticlesItems();
    }

    private void fetchArticlesItems() {
        loading.setValue(true);

        dataManager.getArticlesItems(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, retrofit2.Response<ArticlesResponse> response) {
                loading.setValue(false);
                errorMutableLiveData.setValue(false);
                articlesResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
                loading.setValue(false);
                errorMutableLiveData.setValue(true);
                articlesResponseMutableLiveData.setValue(null);
            }
        });
    }

    LiveData<ArticlesResponse> getArticlesItems(){
        return articlesResponseMutableLiveData;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

    LiveData<Boolean> getError() {
        return errorMutableLiveData;
    }
}
