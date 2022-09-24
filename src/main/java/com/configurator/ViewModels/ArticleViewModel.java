package com.configurator.Entities;

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
