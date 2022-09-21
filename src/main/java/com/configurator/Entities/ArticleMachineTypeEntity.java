package com.configurator.Entities;

import java.util.UUID;
import com.configurator.Interfaces.IBaseEntity;

public class ArticleMachineTypeEntity implements IBaseEntity {

    private UUID articleMachineTypeId = UUID.randomUUID();
    private UUID articleId = UUID.randomUUID();
    private UUID machineTypeId = UUID.randomUUID();
    private float qta = 1;

    public static   final  String PK =   "ArticleMachineTypeId";
    public  static final  String TABLE = "ArticleMachineType";




    public ArticleMachineTypeEntity(UUID articleMachineTypeId, UUID articleId, UUID machineTypeId, float qta) {

        this.articleMachineTypeId = articleMachineTypeId;
        this.articleId = articleId;
        this.machineTypeId = machineTypeId;
        this.qta = qta;
    }

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
