package com.example.nytimesapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.nytimesapp.utils.Constants;
import com.example.nytimesapp.R;

public class SearchActivity extends AppCompatActivity {

    EditText queryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setTitle(R.string.search);

        queryEditText = findViewById(R.id.search_query);
    }

    public void searchForArticles(View view) {
        Intent intent = new Intent(this, ArticleListActivity.class);
        intent.putExtra(Constants.API_TO_CALL, Constants.SEARCH_API);
        intent.putExtra(Constants.SEARCH_QUERY, queryEditText.getText().toString().toLowerCase());
        startActivity(intent);
    }
}
