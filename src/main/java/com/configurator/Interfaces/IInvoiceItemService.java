package com.configurator.Interfaces;

import com.configurator.Entities.InvoiceItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IInvoiceItemService {
    void update(InvoiceItemEntity val) throws SQLException;

    void insert(InvoiceItemEntity val) throws SQLException;

    List<InvoiceItemEntity> get() throws SQLException;

    InvoiceItemEntity get(UUID id) throws SQLException;

    InvoiceItemEntity loadFromResultSet(ResultSet val);
}