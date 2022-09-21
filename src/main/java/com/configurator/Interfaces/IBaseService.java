package com.configurator.Interfaces;

import java.sql.Connection;
import java.util.UUID;

public interface IBaseService {

      Connection getConnection();

      void dete(UUID id);
}
