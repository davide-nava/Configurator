package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IBaseService<T> {

    void update(T val) throws SQLException;

    void insert(T val) throws SQLException;

    List<T> get() throws SQLException;


    T get(UUID id) throws SQLException;

    T loadEntityFromResultSet(ResultSet rs);

}
