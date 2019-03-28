package com.linkdev.practiseapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.linkdev.practiseapp.R;
import com.linkdev.practiseapp.ui.articles.ArticlesFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, ArticlesFragment.newInstance()).commit();
    }
}
