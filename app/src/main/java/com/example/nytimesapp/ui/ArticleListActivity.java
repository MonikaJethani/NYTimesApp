package com.example.nytimesapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nytimesapp.utils.Constants;
import com.example.nytimesapp.http.INYTimesApiCompleted;
import com.example.nytimesapp.http.NYTimesDelegate;
import com.example.nytimesapp.R;
import com.example.nytimesapp.model.ArticleList;

import java.util.List;

public class ArticleListActivity extends AppCompatActivity implements INYTimesApiCompleted {

    List<ArticleList> articleList;

    NYTimesDelegate delegate;

    RecyclerView rvArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        getSupportActionBar().setTitle(R.string.articles);

        rvArticles = findViewById(R.id.rv_articles);
        rvArticles.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        rvArticles.addItemDecoration(dividerItemDecoration);

        String apiToCall = getIntent().getStringExtra(Constants.API_TO_CALL);
        String searchQuery = getIntent().getStringExtra(Constants.SEARCH_QUERY);

        callDelegate(apiToCall, searchQuery);
    }

    private void callDelegate(String apiToCall, String searchQuery) {
        delegate = new NYTimesDelegate(this);
        delegate.callNYTimesApi(apiToCall, searchQuery);
    }

    @Override
    public void onCompleted(ArticleList articleList) {
        if (articleList != null) {
            // Create adapter passing in the sample user data
            NYTimesAdapter adapter = new NYTimesAdapter(articleList.getArticleList());
            // Attach the adapter to the recyclerview to populate items
            rvArticles.setAdapter(adapter);
            // Set layout manager to position the items
        }
    }
}
