package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleMachineEntity;
import com.configurator.Entities.ArticleMachineTypeEntity;
import com.configurator.Entities.ArticleMachineTypeViewModel;

public interface IArticleMachineTypeService  extends IBaseService<ArticleMachineTypeEntity> {
    List<ArticleMachineTypeViewModel> getViewModal() throws SQLException;

    ArticleMachineTypeViewModel loadViewModelFromResultSet(ResultSet rs);

}