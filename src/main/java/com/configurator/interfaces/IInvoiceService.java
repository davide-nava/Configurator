package com.configurator.interfaces;

import com.configurator.entities.InvoiceEntity;
import com.configurator.viewModels.InvoiceViewModel;
import com.configurator.viewModels.LookupViewModel;

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