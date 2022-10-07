package com.configurator.entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleArticleGroupTypeEntity implements Serializable {

    public static final String PK = "ArticleArticleGroupTypeId";
    public static final String TABLE = "ArticleArticleGroupType";
    private UUID articleArticleGroupTypeId;
    private UUID articleGroupTypeId;
    private UUID articleId;
    private float qta = 1;

    public UUID getArticleArticleGroupTypeId() {
        return articleArticleGroupTypeId;
    }

    public void setArticleArticleGroupTypeId(UUID articleArticleGroupTypeId) {
        this.articleArticleGroupTypeId = articleArticleGroupTypeId;
    }

    public UUID getArticleGroupTypeId() {
        return articleGroupTypeId;
    }

    public void setArticleGroupTypeId(UUID articleGroupTypeId) {
        this.articleGroupTypeId = articleGroupTypeId;
    }

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public float getQta() {
        return qta;
    }

    public void setQta(float qta) {
        this.qta = qta;
    }

}
