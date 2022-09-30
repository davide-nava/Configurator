package com.configurator.Interfaces;

import com.configurator.Entities.InvoiceEntity;
import com.configurator.ViewModels.InvoiceViewModel;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IInvoiceService extends IBaseService<InvoiceEntity> {
    List<InvoiceViewModel> getViewModal() throws SQLException;

    InvoiceViewModel loadViewModelFromResultSet(ResultSet rs);
    List<LookupViewModel> getLookupViewModal() throws SQLException;

}