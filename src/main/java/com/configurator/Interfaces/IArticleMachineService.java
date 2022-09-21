package com.configurator.Interfaces;

import com.configurator.Entities.ArticleMachineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IArticleMachineService {
    void update(ArticleMachineEntity val) throws SQLException;

    void insert(ArticleMachineEntity val) throws SQLException;

    List<ArticleMachineEntity> get() throws SQLException;

    ArticleMachineEntity get(UUID id) throws SQLException;

    ArticleMachineEntity loadFromResultSet(ResultSet val);
}
