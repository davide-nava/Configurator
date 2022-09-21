package com.configurator.Interfaces;

import com.configurator.Entities.ArticleEntity;

import java.util.List;
import java.util.UUID;


public interface  IArticleService {
                      public ArticleEntity set(ArticleEntity val);

    public List<ArticleEntity> get();

    public ArticleEntity get(UUID id);

    public void delete(ArticleEntity val);

    public void delete(UUID id);
}
