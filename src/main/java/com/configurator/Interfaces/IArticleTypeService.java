package com.configurator.Interfaces;
import java.util.*;

public interface  IArticleTypeService {
                    public IArticleTypeService set(IArticleTypeService val);

    public List<IArticleTypeService> get();

    public IArticleTypeService get(UUID id);

    public void delete(IArticleTypeService val);

    public void delete(UUID id);
}
