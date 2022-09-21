package com.configurator.Interfaces;

import com.configurator.Entities.ArticleMachineTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleMachineTypeService {
    void update(ArticleMachineTypeEntity val) throws SQLException;

    void insert(ArticleMachineTypeEntity val) throws SQLException;

    List<ArticleMachineTypeEntity> get() throws SQLException;

    ArticleMachineTypeEntity get(UUID id) throws SQLException;

    ArticleMachineTypeEntity loadFromResultSet(ResultSet val);
}