package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;

public interface IArticleArticleGroupTypeService {
    void set(ArticleArticleGroupTypeEntity val);

    List<ArticleArticleGroupTypeEntity> get();

    ArticleArticleGroupTypeEntity get(UUID id);

    ArticleArticleGroupTypeEntity loadFromResultSet(ResultSet val);

}
