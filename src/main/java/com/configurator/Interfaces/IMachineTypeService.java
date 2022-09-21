package com.configurator.Interfaces;

import com.configurator.Entities.MachineTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public interface IMachineTypeService {
    void update(MachineTypeEntity val) throws SQLException;

    void insert(MachineTypeEntity val) throws SQLException;

    List<MachineTypeEntity> get() throws SQLException;

    MachineTypeEntity get(UUID id) throws SQLException;

    MachineTypeEntity loadFromResultSet(ResultSet val);
}