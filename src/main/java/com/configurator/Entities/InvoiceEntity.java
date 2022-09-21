package com.configurator.Entities;

import java.util.Date;
import java.util.UUID;

public class InvoiceEntity {

    private UUID invoiceId = UUID.randomUUID();
    private UUID customerId = UUID.randomUUID();
    private Date dt ;
    private float total ;

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
