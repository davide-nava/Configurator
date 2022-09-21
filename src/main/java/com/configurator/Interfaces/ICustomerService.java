package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.CustomerEntity;

public interface ICustomerService {
    void set(CustomerEntity val);

    List<CustomerEntity> get();

    CustomerEntity get(UUID id);

    CustomerEntity loadFromResultSet(ResultSet val);
}