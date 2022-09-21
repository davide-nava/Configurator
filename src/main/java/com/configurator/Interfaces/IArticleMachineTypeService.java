package com.configurator.Interfaces;

import java.util.*;


public interface  IArticleMachineTypeService {
                       public IArticleMachineTypeService set(IArticleMachineTypeService val);

    public List<IArticleMachineTypeService> get();

    public IArticleMachineTypeService get(UUID id);

    public void delete(IArticleMachineTypeService val);

    public void delete(UUID id);
}
