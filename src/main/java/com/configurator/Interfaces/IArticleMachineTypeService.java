package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleMachineTypeEntity;

public interface IArticleMachineTypeService {
    void set(ArticleMachineTypeEntity val);

    List<ArticleMachineTypeEntity> get();

    ArticleMachineTypeEntity get(UUID id);

    ArticleMachineTypeEntity loadFromResultSet(ResultSet val);
}