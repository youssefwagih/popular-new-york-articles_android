package com.linkdev.practiseapp.ui.articles;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.linkdev.practiseapp.R;
import com.linkdev.practiseapp.adapters.ArticlesAdapter;
import com.linkdev.practiseapp.repository.model.ArticlesResponse;


public class ArticlesFragment extends Fragment {
    private ArticlesAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar pbLoading;

    private ArticlesViewModel articlesViewModel;

    public ArticlesFragment() {
        // Required empty public constructor
    }

    public static ArticlesFragment newInstance() {
        return new ArticlesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        recyclerView = view.findViewById(R.id.customRecyclerView);
        pbLoading = view.findViewById(R.id.pbLoading);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        articlesViewModel = ViewModelProviders.of(this).get(ArticlesViewModel.class);

        articlesViewModel.getArticlesItems().observe(this, new Observer<ArticlesResponse>() {
            @Override
            public void onChanged(@Nullable ArticlesResponse articlesResponse) {
                if (articlesResponse != null)
                    showArticlesList(articlesResponse);
            }
        });


        articlesViewModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isLoading) {
                if (isLoading != null) {
                    pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                }
            }
        });

        articlesViewModel.getError().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean error) {
                if (error) {
                    Toast.makeText(getContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showArticlesList(ArticlesResponse articlesResponse) {
        if (articlesResponse != null && articlesResponse.getResults() != null && articlesResponse.getResults().size() > 0) {
            adapter = new ArticlesAdapter(getContext(), articlesResponse.getResults());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }
}
