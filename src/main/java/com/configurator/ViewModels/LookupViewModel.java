package com.configurator.ViewModels;

import java.io.Serializable;
import java.util.UUID;

public class LookupViewModel implements Serializable {

    private UUID id;
    private String desc = "";

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
