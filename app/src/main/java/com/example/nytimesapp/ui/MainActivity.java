package com.example.nytimesapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nytimesapp.utils.Constants;
import com.example.nytimesapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveToArticleActivity(String apitoCall) {
        Intent intent = new Intent(this, ArticleListActivity.class);
        intent.putExtra(Constants.API_TO_CALL, apitoCall);
        intent.putExtra(Constants.SEARCH_QUERY,"");
        startActivity(intent);
    }

    public void getMostViewed(View view) {
        moveToArticleActivity(Constants.MOST_VIEWED_API);
    }

    public void getMostShared(View view) {
        moveToArticleActivity(Constants.MOST_SHARED_API);
    }

    public void getMostEmailed(View view) {
        moveToArticleActivity(Constants.MOST_EMAILED_API);
    }

    public void doSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
