package com.configurator.entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleTypeEntity implements Serializable {

    public static final String PK = "ArticleTypeId";
    public static final String TABLE = "ArticleType";
    private UUID articleTypeId;
    private String desc = "";
    private int year = 2022;

    public UUID getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(UUID articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
