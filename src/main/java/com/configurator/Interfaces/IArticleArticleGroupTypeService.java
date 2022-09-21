package com.configurator.Interfaces;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;

import java.util.*;

public interface   IArticleArticleGroupTypeService {
    public ArticleArticleGroupTypeEntity set(ArticleArticleGroupTypeEntity val);

    public List<ArticleArticleGroupTypeEntity> get();

    public ArticleArticleGroupTypeEntity get(UUID id);

    public void delete(ArticleArticleGroupTypeEntity val);

    public void delete(UUID id);
}
