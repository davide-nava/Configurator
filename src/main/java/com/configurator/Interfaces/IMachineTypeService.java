package com.configurator.Interfaces;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import com.javatpoint.bean.MachineTypeEntity;

public interface IMachineTypeService {
    void set(MachineTypeEntity val);

    List<MachineTypeEntity> get();

    MachineTypeEntity get(UUID id);

    MachineTypeEntity loadFromResultSet(ResultSet val);
}