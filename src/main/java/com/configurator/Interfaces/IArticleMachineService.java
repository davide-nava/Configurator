package com.configurator.Interfaces;

import com.configurator.Entities.ArticleMachineEntity;

import java.util.*;


public interface  IArticleMachineService {
                          public ArticleMachineEntity set(ArticleMachineEntity val);

    public List<ArticleMachineEntity> get();

    public ArticleMachineEntity get(UUID id);

    public void delete(ArticleMachineEntity val);

    public void delete(UUID id);
}
