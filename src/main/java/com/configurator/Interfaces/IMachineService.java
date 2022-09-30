package com.configurator.Interfaces;

import com.configurator.Entities.MachineEntity;
import com.configurator.ViewModels.LookupViewModel;
import com.configurator.ViewModels.MachineViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IMachineService extends IBaseService<MachineEntity> {
    List<MachineViewModel> getViewModel() throws SQLException;

    MachineViewModel loadViewModelFromResultSet(ResultSet rs);

    List<LookupViewModel> getLookupViewModel() throws SQLException;

}