package com.example.nytimesapp.http;

import com.example.nytimesapp.utils.Constants;
import com.example.nytimesapp.model.ArticleList;

public class NYTimesDelegate implements INYTimesApiCompleted {

    private INYTimesApiCompleted presenter;

    public NYTimesDelegate(INYTimesApiCompleted presenter) {
        this.presenter = presenter;
    }

    public void callNYTimesApi(String apiToCall,String searchTerm) {
        NYTimesRequest request = new NYTimesRequest(this);
        if(Constants.SEARCH_API.equals(apiToCall))
            request.doOperation(Constants.SEARCH_ENDPOINT+searchTerm+".json?"+Constants.API_KEY_STRING);

        if(Constants.MOST_EMAILED_API.equals(apiToCall))
            request.doOperation(Constants.MOST_EMAILED_ENDPOINT);

        if(Constants.MOST_SHARED_API.equals(apiToCall))
            request.doOperation(Constants.MOST_SHARED_ENDPOINT);

        if(Constants.MOST_VIEWED_API.equals(apiToCall))
            request.doOperation(Constants.MOST_VIEWED_ENDPOINT);
    }

    @Override
    public void onCompleted(ArticleList articleList) {
        presenter.onCompleted(articleList);
    }
}
