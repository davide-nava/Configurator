package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Entities.ArticleArticleGroupTypeViewModel;

public interface IArticleArticleGroupTypeService extends IBaseService<ArticleArticleGroupTypeEntity> {

    List<ArticleArticleGroupTypeViewModel> getViewModal() throws SQLException;

    ArticleArticleGroupTypeViewModel loadViewModelFromResultSet(ResultSet rs);

}
