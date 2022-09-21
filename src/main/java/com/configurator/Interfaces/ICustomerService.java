package com.configurator.Interfaces;

import com.configurator.Entities.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ICustomerService {
    void update(CustomerEntity val) throws SQLException;

    void insert(CustomerEntity val) throws SQLException;

    List<CustomerEntity> get() throws SQLException;

    CustomerEntity get(UUID id) throws SQLException;

    CustomerEntity loadFromResultSet(ResultSet val);
}