package com.configurator.interfaces;

import com.configurator.entities.ArticleMachineEntity;
import com.configurator.viewModels.ArticleMachineViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleMachineService extends IBaseService<ArticleMachineEntity> {
    List<ArticleMachineViewModel> getViewModel() throws SQLException;

    ArticleMachineViewModel getViewModel(UUID id) throws SQLException;

    ArticleMachineViewModel loadViewModelFromResultSet(ResultSet rs);

}
