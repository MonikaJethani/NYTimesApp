package com.example.nytimesapp.model;

import java.util.ArrayList;
import java.util.List;

public class ArticleList {

    private List<Article> articleList;

    public ArticleList() {
        articleList = new ArrayList<>();
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void add(Article article) {
        articleList.add(article);
    }
}
