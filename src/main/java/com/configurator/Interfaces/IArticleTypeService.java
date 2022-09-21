package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleTypeEntity;

public interface IArticleTypeService {
    void set(ArticleTypeEntity val);

    List<ArticleTypeEntity> get();

    ArticleTypeEntity get(UUID id);

    ArticleTypeEntity loadFromResultSet(ResultSet val);
}