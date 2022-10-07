package com.configurator.interfaces;

import com.configurator.entities.ArticleEntity;
import com.configurator.viewModels.ArticleViewModel;
import com.configurator.viewModels.LookupViewModel;

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