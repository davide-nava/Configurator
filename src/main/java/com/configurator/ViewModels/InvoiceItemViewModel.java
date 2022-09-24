package com.configurator.Entities;

import java.io.Serializable;

public class InvoiceItemViewModel extends InvoiceItemEntity implements Serializable {

    private String invoiceItemDesc = "";
    private String invoiceDesc = "";
    private String articleDesc = "";
    private String machineDesc = "";

    public String getInvoiceItemDesc() {
        return invoiceItemDesc;
    }

    public void setInvoiceItemDesc(String invoiceItemDesc) {
        this.invoiceItemDesc = invoiceItemDesc;
    }

    public String getInvoiceDesc() {
        return invoiceDesc;
    }

    public void setInvoiceDesc(String invoiceDesc) {
        this.invoiceDesc = invoiceDesc;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getMachineDesc() {
        return machineDesc;
    }

    public void setMachineDesc(String machineDesc) {
        this.machineDesc = machineDesc;
    }

}
