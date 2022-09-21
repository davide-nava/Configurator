package com.configurator.Entities;

import java.util.UUID;

public class CustomerEntity {

    public static final String PK = "CustomerId";
    public static final String TABLE = "Customer";
    private UUID customerId = UUID.randomUUID();
    private String name = "";
    private String code = "";

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
