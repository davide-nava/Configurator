package com.configurator.entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleEntity implements Serializable {

    public static final String PK = "ArticleId";
    public static final String TABLE = "Article";
    private UUID articleId;
    private UUID articleTypeId;
    private float basePrice = 1;
    private String code = "";
    private String name = "";
    private String doc = "";
    private String desc = "";
    private boolean isMachine = false;

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(UUID articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsMachine() {
        return isMachine;
    }

    public void setIsMachine(boolean isMachine) {
        this.isMachine = isMachine;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
