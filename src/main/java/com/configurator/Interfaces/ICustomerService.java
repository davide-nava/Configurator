package com.configurator.Interfaces;

import com.configurator.Entities.CustomerEntity;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService extends IBaseService<CustomerEntity> {
    List<LookupViewModel> getLookupViewModel() throws SQLException;

}