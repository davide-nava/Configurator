package com.configurator.Interfaces;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleArticleGroupTypeService {
    void update(ArticleArticleGroupTypeEntity val) throws SQLException;

    void insert(ArticleArticleGroupTypeEntity val) throws SQLException;

    List<ArticleArticleGroupTypeEntity> get() throws SQLException;

    ArticleArticleGroupTypeEntity get(UUID id) throws SQLException;

    ArticleArticleGroupTypeEntity loadFromResultSet(ResultSet val);

}
