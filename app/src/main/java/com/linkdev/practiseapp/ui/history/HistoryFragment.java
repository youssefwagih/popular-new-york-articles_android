package com.linkdev.practiseapp.ui.history;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkdev.practiseapp.R;
import com.linkdev.practiseapp.adapters.CustomAdapter;
import com.linkdev.practiseapp.repository.model.Repo;

import java.util.List;


public class HistoryFragment extends Fragment {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    private HistoryViewModel historyViewModel;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_repos, container, false);
        recyclerView = view.findViewById(R.id.customRecyclerView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        historyViewModel = new WeatherViewModel(getActivity().getApplication());
        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);

/*        historyViewModel.getRepos().observe(this, new Observer<List<Repo>>() {
            @Override
            public void onChanged(@Nullable List<Repo> repos) {
                showDataList(repos);
            }
        });*/
    }

    private void showDataList(List<Repo> photoList) {
        adapter = new CustomAdapter(getContext(), photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
