package com.configurator.Entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleGroupTypeViewModel implements Serializable{
private static final long serialVersionUID = 1L;
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
