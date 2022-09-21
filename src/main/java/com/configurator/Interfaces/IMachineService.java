package com.configurator.Interfaces;
import java.util.*;

public interface  IMachineService {
          public IMachineService set(IMachineService val);

    public List<IMachineService> get();

    public IMachineService get(UUID id);

    public void delete(IMachineService val);

    public void delete(UUID id);
}
