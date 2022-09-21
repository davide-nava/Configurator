package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.InvoiceItemEntity;

public interface IInvoiceItemService {
    void set(InvoiceItemEntity val);

    List<InvoiceItemEntity> get();

    InvoiceItemEntity get(UUID id);

    InvoiceItemEntity loadFromResultSet(ResultSet val);
}