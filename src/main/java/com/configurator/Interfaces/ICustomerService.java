package com.configurator.Interfaces;

import java.util.*;

public interface  ICustomerService {
                 public ICustomerService set(ICustomerService val);

    public List<ICustomerService> get();

    public ICustomerService get(UUID id);

    public void delete(ICustomerService val);

    public void delete(UUID id);
}
