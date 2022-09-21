package com.configurator.Entities;

import java.util.UUID;

public class ArticleGroupTypeEntity {

    public static final String PK = "ArticleGroupTypeId";
    public static final String TABLE = "ArticleGroupType";
    private UUID articleGroupTypeId = UUID.randomUUID();
    private String desc = "";
    private String code = "";
    private String productionOrder = "";

    public UUID getArticleGroupTypeId() {
        return articleGroupTypeId;
    }

    public void setArticleGroupTypeId(UUID articleGroupTypeId) {
        this.articleGroupTypeId = articleGroupTypeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(String productionOrder) {
        this.productionOrder = productionOrder;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
