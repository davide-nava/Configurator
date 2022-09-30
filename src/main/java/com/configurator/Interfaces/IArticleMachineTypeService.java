package com.configurator.Interfaces;

import com.configurator.Entities.ArticleMachineTypeEntity;
import com.configurator.ViewModels.ArticleMachineTypeViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IArticleMachineTypeService extends IBaseService<ArticleMachineTypeEntity> {
    List<ArticleMachineTypeViewModel> getViewModel() throws SQLException;

    ArticleMachineTypeViewModel loadViewModelFromResultSet(ResultSet rs);

}