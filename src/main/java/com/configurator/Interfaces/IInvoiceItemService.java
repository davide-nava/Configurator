package com.configurator.Interfaces;

import com.configurator.Entities.InvoiceItemEntity;
import com.configurator.ViewModels.InvoiceItemViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IInvoiceItemService extends IBaseService<InvoiceItemEntity> {

    List<InvoiceItemViewModel> getViewModal() throws SQLException;

    InvoiceItemViewModel loadViewModelFromResultSet(ResultSet rs);

}