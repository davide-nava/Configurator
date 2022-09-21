package com.configurator.Interfaces;

import com.configurator.Entities.InvoiceEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IInvoiceService {
    void update(InvoiceEntity val) throws SQLException;

    void insert(InvoiceEntity val) throws SQLException;

    List<InvoiceEntity> get() throws SQLException;

    InvoiceEntity get(UUID id) throws SQLException;

    InvoiceEntity loadFromResultSet(ResultSet val);
}