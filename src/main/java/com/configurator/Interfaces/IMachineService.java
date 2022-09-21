package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.MachineEntity;

public interface IMachineService {
    void set(MachineEntity val);

    List<MachineEntity> get();

    MachineEntity get(UUID id);

    MachineEntity loadFromResultSet(ResultSet val);
}