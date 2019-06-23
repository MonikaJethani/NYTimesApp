package com.example.nytimesapp.http;

import com.example.nytimesapp.utils.Constants;
import com.example.nytimesapp.model.Article;
import com.example.nytimesapp.model.ArticleList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NYTimesJsonParser {

   private static ArticleList articleList;

    public static ArticleList getArticleList(JSONObject jsonObject) {
        articleList = new ArticleList();
        String title, datePublished;
        JSONArray results = jsonObject.optJSONArray(Constants.RESULTS);
        for(int i = 0; i< results.length(); i++) {
            try {
                JSONObject articleObj = (JSONObject)results.get(i);
                title = articleObj.getString(Constants.TITLE);
                datePublished = articleObj.getString(Constants.DATE_PUBLISHED);
                if(datePublished.contains("T")) {
                    datePublished = datePublished.substring(0, datePublished.indexOf("T"));
                }
                Article article = new Article(title, datePublished);
                articleList.add(article);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return articleList;
    }
}
