package com.configurator.interfaces;

import com.configurator.entities.InvoiceItemEntity;
import com.configurator.viewModels.InvoiceItemViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IInvoiceItemService extends IBaseService<InvoiceItemEntity> {

    List<InvoiceItemViewModel> getViewModel() throws SQLException;

    InvoiceItemViewModel getViewModel(UUID id) throws SQLException;

    InvoiceItemViewModel loadViewModelFromResultSet(ResultSet rs);


}