package com.configurator.viewModels;

import com.configurator.entities.ArticleEntity;

import java.io.Serializable;

public class ArticleViewModel extends ArticleEntity implements Serializable {

    private String articleTypeDesc = "";

    public String getArticleTypeDesc() {
        return articleTypeDesc;
    }

    public void setArticleTypeDesc(String articleTypeDesc) {
        this.articleTypeDesc = articleTypeDesc;
    }

}
