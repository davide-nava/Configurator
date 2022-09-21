package com.configurator.Interfaces;

import com.configurator.Entities.ArticleGroupTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleGroupTypeService {
    void update(ArticleGroupTypeEntity val) throws SQLException;

    void insert(ArticleGroupTypeEntity val) throws SQLException;

    List<ArticleGroupTypeEntity> get() throws SQLException;

    ArticleGroupTypeEntity get(UUID id) throws SQLException;

    ArticleGroupTypeEntity loadFromResultSet(ResultSet val);
}
