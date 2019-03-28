package com.linkdev.practiseapp.ui.articles;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.linkdev.practiseapp.repository.model.ArticlesResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class ArticlesViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    ArticlesViewModel articlesViewModel;

    @Before
    public void setupTasksViewModel() {
        MockitoAnnotations.initMocks(this);

        articlesViewModel = new ArticlesViewModel();
    }

    @Test
    public void onArticlesFailure() {
        articlesViewModel.loading.setValue(false);
        articlesViewModel.errorMutableLiveData.setValue(true);

        assertFalse(articlesViewModel.getLoading().getValue()  && articlesViewModel.getError().getValue());
    }

    @Test
    public void onArticlesSuccess() {
        articlesViewModel.loading.setValue(false);
        articlesViewModel.errorMutableLiveData.setValue(false);

        assertFalse(articlesViewModel.getLoading().getValue()  && articlesViewModel.getError().getValue());
    }
}