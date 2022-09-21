package com.configurator.Interfaces;

import java.util.*;

public interface  IMachineTypeService {
        public IMachineTypeService set(IMachineTypeService val);

    public List<IMachineTypeService> get();

    public IMachineTypeService get(UUID id);

    public void delete(IMachineTypeService val);

    public void delete(UUID id);
}
