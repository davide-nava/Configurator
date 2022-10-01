package com.configurator.Interfaces;

import com.configurator.Entities.InvoiceEntity;
import com.configurator.ViewModels.InvoiceViewModel;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IInvoiceService extends IBaseService<InvoiceEntity> {
    List<InvoiceViewModel> getViewModel() throws SQLException;

    InvoiceViewModel getViewModel(UUID id) throws SQLException;

    InvoiceViewModel loadViewModelFromResultSet(ResultSet rs);

    List<LookupViewModel> getLookupViewModel() throws SQLException;

}