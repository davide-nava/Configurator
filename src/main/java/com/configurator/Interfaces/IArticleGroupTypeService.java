package com.configurator.Interfaces;
import java.util.*;


public interface  IArticleGroupTypeService {
                           public IArticleGroupTypeService set(IArticleGroupTypeService val);

    public List<IArticleGroupTypeService> get();

    public IArticleGroupTypeService get(UUID id);

    public void delete(IArticleGroupTypeService val);

    public void delete(UUID id);
}
