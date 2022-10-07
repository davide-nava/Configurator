package com.configurator.interfaces;

import com.configurator.entities.ArticleArticleGroupTypeEntity;
import com.configurator.viewModels.ArticleArticleGroupTypeViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleArticleGroupTypeService extends IBaseService<ArticleArticleGroupTypeEntity> {

    List<ArticleArticleGroupTypeViewModel> getViewModel() throws SQLException;

    ArticleArticleGroupTypeViewModel getViewModel(UUID id) throws SQLException;

    ArticleArticleGroupTypeViewModel loadViewModelFromResultSet(ResultSet rs);

}
