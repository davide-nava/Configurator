package com.configurator.Interfaces;
import com.configurator.Entities.ArticleGroupTypeEntity;

import java.util.*;


public interface  IArticleGroupTypeService {
                           public ArticleGroupTypeEntity set(ArticleGroupTypeEntity val);

    public List<ArticleGroupTypeEntity> get();

    public ArticleGroupTypeEntity get(UUID id);

    public void delete(ArticleGroupTypeEntity val);

    public void delete(UUID id);
}
