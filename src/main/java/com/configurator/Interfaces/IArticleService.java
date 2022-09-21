package com.configurator.Interfaces;

import java.util.List;
import java.util.UUID;


public interface  IArticleService {
                      public IArticleService set(IArticleService val);

    public List<IArticleService> get();

    public IArticleService get(UUID id);

    public void delete(IArticleService val);

    public void delete(UUID id);
}
