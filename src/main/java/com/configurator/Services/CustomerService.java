package com.configurator.Services;

import com.configurator.Entities.CustomerEntity;
import com.configurator.Interfaces.ICustomerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CustomerService extends BaseService implements ICustomerService {

    @Override
    public void update(CustomerEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update Customer set   Name=?, Code=? where CustomerId=?");

            ps.setString(1, val.getName());
            ps.setString(2, val.getCode());

            ps.setString(3, val.getCustomerId().toString());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(CustomerEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into Customer ( CustomerId, Name, Code) values ( ?, ?,    ?)");

            ps.setString(1, val.getCustomerId().toString());
            ps.setString(2, val.getName());
            ps.setString(3, val.getCode());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public CustomerEntity loadFromResultSet(ResultSet rs) {
        CustomerEntity result = null;
        try {
            if (rs.next()) {
                result = new CustomerEntity();

                result.setCustomerId(UUID.fromString(rs.getString("CustomerId")));
                result.setName(rs.getString("Name"));
                result.setCode(rs.getString("Code"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<CustomerEntity> get() throws SQLException {
        List<CustomerEntity> result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  Customer");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadFromResultSet(rs));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (rs != null)
                rs.close();

            if (con != null)
                con.close();

            return result;
        }
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

            ps.setString(1, id.toString());

            rs = ps.executeQuery();

            if (rs.next()) {
                result = loadFromResultSet(rs);
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (rs != null)
                rs.close();

            if (con != null)
                con.close();

            return result;
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            deleteExecute(CustomerEntity.TABLE, CustomerEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}