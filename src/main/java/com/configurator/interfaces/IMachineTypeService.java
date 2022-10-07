package com.configurator.interfaces;

import com.configurator.entities.MachineTypeEntity;
import com.configurator.viewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IMachineTypeService extends IBaseService<MachineTypeEntity> {
    List<LookupViewModel> getLookupViewModel() throws SQLException;

}