package com.configurator.Interfaces;

import com.configurator.Entities.ArticleTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleTypeService {
    void update(ArticleTypeEntity val) throws SQLException;

    void insert(ArticleTypeEntity val) throws SQLException;

    List<ArticleTypeEntity> get() throws SQLException;

    ArticleTypeEntity get(UUID id) throws SQLException;

    ArticleTypeEntity loadFromResultSet(ResultSet val);
}