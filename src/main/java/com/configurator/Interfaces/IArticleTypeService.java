package com.configurator.Interfaces;
import com.configurator.Entities.ArticleTypeEntity;

import java.util.*;

public interface  IArticleTypeService {
                    public ArticleTypeEntity set(ArticleTypeEntity val);

    public List<ArticleTypeEntity> get();

    public ArticleTypeEntity get(UUID id);

    public void delete(ArticleTypeEntity val);

    public void delete(UUID id);
}
