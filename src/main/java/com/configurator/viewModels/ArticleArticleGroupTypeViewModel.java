package com.configurator.viewModels;

import com.configurator.entities.ArticleArticleGroupTypeEntity;

import java.io.Serializable;

public class ArticleArticleGroupTypeViewModel extends ArticleArticleGroupTypeEntity implements Serializable {

    private String articleGroupTypeDesc = "";
    private String articleDesc = "";

    public String getArticleGroupTypeDesc() {
        return articleGroupTypeDesc;
    }

    public void setArticleGroupTypeDesc(String articleGroupTypeDesc) {
        this.articleGroupTypeDesc = articleGroupTypeDesc;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

}
