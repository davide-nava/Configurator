package com.configurator.Interfaces;
import com.configurator.Entities.MachineEntity;

import java.util.*;

public interface  IMachineService {
          public MachineEntity set(MachineEntity val);

    public List<MachineEntity> get();

    public MachineEntity get(UUID id);

    public void delete(MachineEntity val);

    public void delete(UUID id);
}
