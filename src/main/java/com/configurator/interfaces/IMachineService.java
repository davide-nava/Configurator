package com.configurator.interfaces;

import com.configurator.entities.MachineEntity;
import com.configurator.viewModels.LookupViewModel;
import com.configurator.viewModels.MachineViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IMachineService extends IBaseService<MachineEntity> {
    List<MachineViewModel> getViewModel() throws SQLException;

    MachineViewModel getViewModel(UUID id) throws SQLException;

    MachineViewModel loadViewModelFromResultSet(ResultSet rs);

    List<LookupViewModel> getLookupViewModel() throws SQLException;

}