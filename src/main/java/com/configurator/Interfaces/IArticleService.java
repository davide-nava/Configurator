package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleEntity;
import com.configurator.Entities.ArticleMachineTypeEntity;
import com.configurator.Entities.ArticleViewModel;

public interface IArticleService extends IBaseService<ArticleEntity> {
    List<ArticleViewModel> getViewModal() throws SQLException;

    ArticleViewModel loadViewModelFromResultSet(ResultSet rs);

}