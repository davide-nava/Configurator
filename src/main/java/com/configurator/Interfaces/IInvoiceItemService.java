package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Entities.InvoiceItemEntity;
import com.configurator.Entities.InvoiceItemViewModel;

public interface IInvoiceItemService extends IBaseService<InvoiceItemEntity> {

    List<InvoiceItemViewModel> getViewModal() throws SQLException;

    InvoiceItemViewModel loadViewModelFromResultSet(ResultSet rs);

}