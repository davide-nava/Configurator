package com.configurator.Entities;

import java.util.UUID;
import com.configurator.Interfaces.IBaseEntity;

public class ArticleMachineEntity implements IBaseEntity {

    private UUID articleMachineId = UUID.randomUUID();
    private UUID machineId = UUID.randomUUID();
    private UUID articleId = UUID.randomUUID();
    private float qta = 1;
    private String note = "";

    public static   final  String PK =   "ArticleMachineId";
    public  static final  String TABLE = "ArticleMachine";



    public ArticleMachineEntity(UUID articleMachineId, UUID machineId, UUID articleId, float qta, String note) {

        this.articleMachineId = articleMachineId;
        this.machineId = machineId;
        this.articleId = articleId;
        this.note = note;
        this.qta = qta;
    }

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
