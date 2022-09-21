package com.configurator.Services;

import com.configurator.Interfaces.IBaseService;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseService implements IBaseService {

    public   Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/DB/configurator.db");
        } catch (Exception e) {
            conn = null;
        }
        return conn;
    }
}
