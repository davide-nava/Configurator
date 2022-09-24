package com.configurator.Entities;

import java.io.Serializable;

public class ArticleMachineTypeViewModel extends ArticleMachineTypeEntity implements Serializable {

    private String articleDesc = "";
    private String machineTypeDesc = "";

    public String getMachineTypeDesc() {
        return machineTypeDesc;
    }

    public void setMachineTypeDesc(String machineTypeDesc) {
        this.machineTypeDesc = machineTypeDesc;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

}
