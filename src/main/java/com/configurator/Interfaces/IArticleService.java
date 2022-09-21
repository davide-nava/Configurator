package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleEntity;

public interface IArticleService {
    void set(ArticleEntity val);

    List<ArticleEntity> get();

    ArticleEntity get(UUID id);

    ArticleEntity loadFromResultSet(ResultSet val);
}