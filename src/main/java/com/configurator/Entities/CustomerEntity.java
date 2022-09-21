package com.configurator.Entities;

import java.util.UUID;
import com.configurator.Interfaces.IBaseEntity;

public class CustomerEntity implements IBaseEntity {

    private UUID customerId = UUID.randomUUID();
    private String name = "";
    private String code = "";

    public static   final  String PK =   "CustomerId";
    public  static final  String TABLE = "Customer";



    public CustomerEntity(UUID customerId, String code, String name) {

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
