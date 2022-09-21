package com.configurator.Entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleViewModel implements Serializable{
private static final long serialVersionUID = 1L;
    private UUID articleId = UUID.randomUUID();
    private UUID articleTypeId = UUID.randomUUID();
    private float basePrice =1;
    private String code = "";
    private String img = "";
    private String name = "";
    private String doc = "";
    private String desc = "";

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
