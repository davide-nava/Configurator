package com.configurator.Interfaces;

import java.util.*;


public interface  IArticleMachineService {
                          public IArticleMachineService set(IArticleMachineService val);

    public List<IArticleMachineService> get();

    public IArticleMachineService get(UUID id);

    public void delete(IArticleMachineService val);

    public void delete(UUID id);
}
