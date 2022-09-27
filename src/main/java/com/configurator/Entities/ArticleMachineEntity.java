package com.configurator.Entities;

import java.io.Serializable;
import java.util.UUID;

public class ArticleMachineEntity implements Serializable {

    public static final String PK = "ArticleMachineId";
    public static final String TABLE = "ArticleMachine";
    private UUID articleMachineId;
    private UUID machineId;
    private UUID articleId;
    private float qta = 1;
    private String note = "";

    public UUID getArticleMachineId() {
        return articleMachineId;
    }

    public void setArticleMachineId(UUID articleMachineId) {
        this.articleMachineId = articleMachineId;
    }

    public UUID getMachineId() {
        return machineId;
    }

    public void setMachineId(UUID machineId) {
        this.machineId = machineId;
    }

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getQta() {
        return qta;
    }

    public void setQta(float qta) {
        this.qta = qta;
    }
}
