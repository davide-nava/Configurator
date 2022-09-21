package com.configurator.Interfaces;

import com.configurator.Entities.MachineTypeEntity;

import java.util.*;

public interface  IMachineTypeService {
        public MachineTypeEntity set(MachineTypeEntity val);

    public List<MachineTypeEntity> get();

    public MachineTypeEntity get(UUID id);

    public void delete(MachineTypeEntity val);

    public void delete(UUID id);
}
