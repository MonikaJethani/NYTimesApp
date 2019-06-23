package com.example.nytimesapp.http;

import com.example.nytimesapp.model.ArticleList;

public interface INYTimesApiCompleted {
    void onCompleted(ArticleList articleList);
}
