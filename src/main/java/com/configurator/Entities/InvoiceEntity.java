package com.configurator.Entities;

import java.util.Date;
import java.util.UUID;

public class InvoiceEntity implements IBaseEntity {

    private UUID invoiceId = UUID.randomUUID();
    private UUID customerId = UUID.randomUUID();
    private Date dt;
    private float total;

    @Override
    public String getPk() {
        return "InvoiceId";
    }

    @Override
    public String getTable() {
        return "Invoice";
    }

    public InvoiceEntity(UUID invoiceId, UUID customerId, Date dt, float total) {

        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.dt = dt;
        this.total = total;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(UUID invoiceId) {
        this.invoiceId = invoiceId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
