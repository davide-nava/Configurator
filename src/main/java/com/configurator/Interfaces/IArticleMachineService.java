package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleMachineEntity;

public interface IArticleMachineService {
    void set(ArticleMachineEntity val);

    List<ArticleMachineEntity> get();

    ArticleMachineEntity get(UUID id);

    ArticleMachineEntity loadFromResultSet(ResultSet val);
}
