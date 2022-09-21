package com.configurator.Interfaces;

import com.configurator.Entities.MachineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IMachineService {
    void update(MachineEntity val) throws SQLException;

    void insert(MachineEntity val) throws SQLException;

    List<MachineEntity> get() throws SQLException;

    MachineEntity get(UUID id) throws SQLException;

    MachineEntity loadFromResultSet(ResultSet val);
}