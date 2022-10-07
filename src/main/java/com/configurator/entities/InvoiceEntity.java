package com.configurator.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class InvoiceEntity implements Serializable {

    public static final String PK = "InvoiceId";
    public static final String TABLE = "Invoice";
    private UUID invoiceId;
    private UUID customerId;
    private Date dt;
    private float total;
    private String nr;

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

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }
}
