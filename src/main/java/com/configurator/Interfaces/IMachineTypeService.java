package com.configurator.Interfaces;

import com.configurator.Entities.MachineTypeEntity;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IMachineTypeService extends IBaseService<MachineTypeEntity> {
    List<LookupViewModel> getLookupViewModal() throws SQLException;

}