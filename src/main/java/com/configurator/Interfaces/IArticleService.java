package com.configurator.Interfaces;

import com.configurator.Entities.ArticleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleService {
    void update(ArticleEntity val) throws SQLException;

    void insert(ArticleEntity val) throws SQLException;

    List<ArticleEntity> get() throws SQLException;

    ArticleEntity get(UUID id) throws SQLException;

    ArticleEntity loadFromResultSet(ResultSet val);
}