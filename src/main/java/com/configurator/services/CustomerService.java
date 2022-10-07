package com.configurator.services;

import com.configurator.entities.CustomerEntity;
import com.configurator.interfaces.ICustomerService;
import com.configurator.viewModels.LookupViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerService extends BaseService implements ICustomerService {

    @Override
    public void update(CustomerEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update Customer set   Name=?, Code=? where CustomerId=?");

            ps.setString(1, val.getName());
            ps.setString(2, val.getCode());

            ps.setString(3, val.getCustomerId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(CustomerEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into Customer ( CustomerId, Name, Code) values ( ?, ?,    ?)");

            ps.setString(1, val.getCustomerId().toString().toUpperCase());
            ps.setString(2, val.getName());
            ps.setString(3, val.getCode());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public CustomerEntity loadEntityFromResultSet(ResultSet rs) {
        CustomerEntity result = null;
        try {
            if (rs != null) {
                result = new CustomerEntity();

                result.setCustomerId(UUID.fromString(rs.getString("CustomerId")));
                result.setName(rs.getString("Name"));
                result.setCode(rs.getString("Code"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<CustomerEntity> get() throws SQLException {
        List<CustomerEntity> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  Customer");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadEntityFromResultSet(rs));
            }

        } catch (SQLException exception) {
            result = null;
            printSQLException(exception);
        } finally {
            if (rs != null)
                rs.close();

            if (con != null)
                con.close();

        }
        return result;

    }

    @Override
    public CustomerEntity get(UUID id) throws SQLException {

        CustomerEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from Customer where CustomerId=? ");

            ps.setString(1, id.toString().toUpperCase());

            rs = ps.executeQuery();

            if (rs.next()) {
                result = loadEntityFromResultSet(rs);
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (rs != null)
                rs.close();

            if (con != null)
                con.close();

        }
        return result;

    }

    @Override
    public void delete(UUID id) {
        deleteExecute(CustomerEntity.TABLE, CustomerEntity.PK, id);
    }

    @Override
    public List<LookupViewModel> getLookupViewModel() throws SQLException {
        List<LookupViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(" select  CustomerId as 'Id' ,  Code  as 'Desc' from Customer");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadLookupFromResultSet(rs));
            }

        } catch (SQLException exception) {
            result = null;
            printSQLException(exception);
        } finally {
            if (rs != null)
                rs.close();

            if (con != null)
                con.close();

        }
        return result;
    }

}