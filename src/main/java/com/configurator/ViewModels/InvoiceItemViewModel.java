package com.configurator.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class InvoiceItemViewModel implements Serializable{
private static final long serialVersionUID = 1L;
    private UUID invoiceItemId = UUID.randomUUID();
    private UUID invoiceId = UUID.randomUUID();
    private UUID articleId = UUID.randomUUID();
    private UUID machineId = UUID.randomUUID();
    private Date dt;
    private float qta = 1;

    public InvoiceItemViewModel(UUID invoiceItemId, UUID invoiceId , UUID articleId, UUID machineId,  Date dt, float qta ) {
        this.invoiceItemId = invoiceItemId;
        this.invoiceId = invoiceId;
        this.articleId = articleId;
      this.machineId = machineId;
        this.dt = dt;
        this.qta = qta;
    }
    
    public UUID getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(UUID invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(UUID invoiceId) {
        this.invoiceId = invoiceId;
    }

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getMachineId() {
        return machineId;
    }

    public void setMachineId(UUID machineId) {
        this.machineId = machineId;
    }

    public float getQta() {
        return qta;
    }

    public void setQta(float qta) {
        this.qta = qta;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
}
