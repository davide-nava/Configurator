package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Entities.InvoiceEntity;
import com.configurator.Entities.InvoiceViewModel;

public interface IInvoiceService extends IBaseService<InvoiceEntity> {
    List<InvoiceViewModel> getViewModal() throws SQLException;

    InvoiceViewModel loadViewModelFromResultSet(ResultSet rs);

}