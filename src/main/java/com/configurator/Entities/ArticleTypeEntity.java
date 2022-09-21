package com.configurator.Entities;

import java.util.UUID;

public class ArticleTypeEntity {

    private UUID articleTypeId = UUID.randomUUID();
    private String desc = "";
    private String code = "";
    private int year = 2022;

    public ArticleTypeEntity(UUID articleTypeId, String desc , String code, int year ) {
        this.desc = desc;
        this.code = code;
        this.articleTypeId = articleTypeId;
        this.year = year;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
