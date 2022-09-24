package com.configurator.Entities;

import java.io.Serializable;

public class InvoiceViewModel extends InvoiceEntity implements Serializable {

    private String customerDesc = "";

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

}
