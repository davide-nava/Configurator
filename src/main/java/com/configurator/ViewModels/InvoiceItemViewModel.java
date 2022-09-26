package com.configurator.ViewModels;

import com.configurator.Entities.InvoiceItemEntity;

import java.io.Serializable;

public class InvoiceItemViewModel extends InvoiceItemEntity implements Serializable {

    private String invoiceDesc = "";
    private String articleDesc = "";

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


}
