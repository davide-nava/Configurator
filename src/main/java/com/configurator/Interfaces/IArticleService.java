package com.configurator.Interfaces;

import com.configurator.Entities.ArticleEntity;
import com.configurator.ViewModels.ArticleViewModel;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleService extends IBaseService<ArticleEntity> {
    List<ArticleViewModel> getViewModel() throws SQLException;

    ArticleViewModel getViewModel(UUID id) throws SQLException;

    ArticleViewModel loadViewModelFromResultSet(ResultSet rs);

    List<LookupViewModel> getLookupViewModel() throws SQLException;

}