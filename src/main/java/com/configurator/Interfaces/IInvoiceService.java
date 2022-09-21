package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.InvoiceEntity;

public interface IInvoiceService {
    void set(InvoiceEntity val);

    List<InvoiceEntity> get();

    InvoiceEntity get(UUID id);

    InvoiceEntity loadFromResultSet(ResultSet val);
}