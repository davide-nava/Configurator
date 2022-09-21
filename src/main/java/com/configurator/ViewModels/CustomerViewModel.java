package com.configurator.Entities;

import java.io.Serializable;
import java.util.UUID;

public class CustomerViewModel implements Serializable {
private static final long serialVersionUID = 1L;
    private UUID customerId = UUID.randomUUID();
    private String name = "";
    private String code = "";

    public CustomerViewModel(UUID customerId, String code , String name ) {
        this.name = name;
        this.code = code;
        this.customerId = customerId;
    }
    
    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
