package com.configurator.ViewModels;

import com.configurator.Entities.ArticleMachineEntity;

import java.io.Serializable;

public class ArticleMachineViewModel extends ArticleMachineEntity implements Serializable {

    private String articleDesc = "";
    private String machineDesc = "";

    public String getMachineDesc() {
        return machineDesc;
    }

    public void setMachineDesc(String machineDesc) {
        this.machineDesc = machineDesc;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

}
