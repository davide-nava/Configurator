package com.configurator.Entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleMachineTypeEntity implements Serializable {

    public static final String PK = "ArticleMachineTypeId";
    public static final String TABLE = "ArticleMachineType";
    private UUID articleMachineTypeId;
    private UUID articleId;
    private UUID machineTypeId;
    private float qta = 1;

    public UUID getArticleMachineTypeId() {
        return articleMachineTypeId;
    }

    public void setArticleMachineTypeId(UUID articleMachineTypeId) {
        this.articleMachineTypeId = articleMachineTypeId;
    }

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(UUID machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public float getQta() {
        return qta;
    }

    public void setQta(float qta) {
        this.qta = qta;
    }
}
