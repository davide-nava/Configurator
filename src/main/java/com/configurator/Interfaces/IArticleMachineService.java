package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleGroupTypeEntity;
import com.configurator.Entities.ArticleMachineEntity;
import com.configurator.Entities.ArticleMachineViewModel;

public interface IArticleMachineService extends IBaseService<ArticleMachineEntity> {
    List<ArticleMachineViewModel> getViewModal() throws SQLException;

    ArticleMachineViewModel loadViewModelFromResultSet(ResultSet rs);

}
