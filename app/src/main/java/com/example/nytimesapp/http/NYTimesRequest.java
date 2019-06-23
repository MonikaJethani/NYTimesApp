package com.example.nytimesapp.http;

import com.example.nytimesapp.model.ArticleList;

public class NYTimesRequest implements INYTimesCallOperation, INYTimesApiCompleted {

    NYTimesDelegate delegate;

    NYTimesRequest(NYTimesDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doOperation(String endpoint) {
        new NYTimesAsyncTask(this)
                .execute(endpoint);
    }


    @Override
    public void onCompleted(ArticleList articleList) {
        delegate.onCompleted(articleList);
    }

}
