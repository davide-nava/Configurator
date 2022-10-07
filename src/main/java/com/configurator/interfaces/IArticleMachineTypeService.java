package com.configurator.interfaces;

import com.configurator.entities.ArticleMachineTypeEntity;
import com.configurator.viewModels.ArticleMachineTypeViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleMachineTypeService extends IBaseService<ArticleMachineTypeEntity> {
    List<ArticleMachineTypeViewModel> getViewModel() throws SQLException;

    ArticleMachineTypeViewModel getViewModel(UUID id) throws SQLException;

    ArticleMachineTypeViewModel loadViewModelFromResultSet(ResultSet rs);

}