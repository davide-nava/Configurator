package com.configurator.interfaces;

import com.configurator.entities.CustomerEntity;
import com.configurator.viewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService extends IBaseService<CustomerEntity> {
    List<LookupViewModel> getLookupViewModel() throws SQLException;

}