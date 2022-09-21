package com.configurator.Interfaces;

import com.configurator.Entities.ArticleMachineTypeEntity;

import java.util.*;


public interface  IArticleMachineTypeService {
                       public ArticleMachineTypeEntity set(ArticleMachineTypeEntity val);

    public List<ArticleMachineTypeEntity> get();

    public ArticleMachineTypeEntity get(UUID id);

    public void delete(ArticleMachineTypeEntity val);

    public void delete(UUID id);
}
