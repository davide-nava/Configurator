package com.configurator.Interfaces;

import com.configurator.Entities.ArticleMachineEntity;
import com.configurator.ViewModels.ArticleMachineViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IArticleMachineService extends IBaseService<ArticleMachineEntity> {
    List<ArticleMachineViewModel> getViewModal() throws SQLException;

    ArticleMachineViewModel loadViewModelFromResultSet(ResultSet rs);

}
