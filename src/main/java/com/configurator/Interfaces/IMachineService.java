package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Entities.MachineEntity;
import com.configurator.Entities.MachineViewModel;

public interface IMachineService extends IBaseService<MachineEntity> {
    List<MachineViewModel> getViewModal() throws SQLException;

    MachineViewModel loadViewModelFromResultSet(ResultSet rs);
}