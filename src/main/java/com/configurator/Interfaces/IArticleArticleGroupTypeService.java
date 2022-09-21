package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;

public interface IArticleArticleGroupTypeService {
    void set(ArticleArticleGroupTypeEntity val) throws SQLException;

    List<ArticleArticleGroupTypeEntity> get() throws SQLException;

    ArticleArticleGroupTypeEntity get(UUID id) throws SQLException;

    ArticleArticleGroupTypeEntity loadFromResultSet(ResultSet val);

}
