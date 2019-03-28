package com.youssef.practiseapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.youssef.practiseapp.R;
import com.youssef.practiseapp.ui.articles.ArticlesFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, ArticlesFragment.newInstance()).commit();
    }
}
