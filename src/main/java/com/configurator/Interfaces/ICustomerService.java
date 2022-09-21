package com.configurator.Interfaces;

import com.configurator.Entities.CustomerEntity;

import java.util.*;

public interface  ICustomerService {
                 public CustomerEntity set(CustomerEntity val);

    public List<CustomerEntity> get();

    public CustomerEntity get(UUID id);

    public void delete(CustomerEntity val);

    public void delete(UUID id);
}
