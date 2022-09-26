package com.configurator.Interfaces;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.ViewModels.ArticleArticleGroupTypeViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IArticleArticleGroupTypeService extends IBaseService<ArticleArticleGroupTypeEntity> {

    List<ArticleArticleGroupTypeViewModel> getViewModal() throws SQLException;

    ArticleArticleGroupTypeViewModel loadViewModelFromResultSet(ResultSet rs);

}
