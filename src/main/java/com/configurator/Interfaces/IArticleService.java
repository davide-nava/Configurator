package com.configurator.Interfaces;

import com.configurator.Entities.ArticleEntity;
import com.configurator.ViewModels.ArticleViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IArticleService extends IBaseService<ArticleEntity> {
    List<ArticleViewModel> getViewModal() throws SQLException;

    ArticleViewModel loadViewModelFromResultSet(ResultSet rs);

}