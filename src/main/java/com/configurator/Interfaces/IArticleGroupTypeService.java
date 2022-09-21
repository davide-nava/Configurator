package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleGroupTypeEntity;

public interface IArticleGroupTypeService {
    void set(ArticleGroupTypeEntity val);

    List<ArticleGroupTypeEntity> get();

    ArticleGroupTypeEntity get(UUID id);

    ArticleGroupTypeEntity loadFromResultSet(ResultSet val);
}
