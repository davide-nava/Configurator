package com.configurator.Services;

import com.configurator.Entities.InvoiceEntity;
import com.configurator.Interfaces.IInvoiceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class InvoiceService extends BaseService implements IInvoiceService {

    @Override
    public void update(InvoiceEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update Invoice set     Dt=?, CustomerId=?, Total=? where InvoiceId=?");

            ps.setDate(1, new java.sql.Date(val.getDt().getTime()));
            ps.setString(2, val.getCustomerId().toString());
            ps.setFloat(3, val.getTotal());

            ps.setString(4, val.getInvoiceId().toString());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(InvoiceEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into Invoice ( InvoiceId, Dt, CustomerId, Total) values ( ?, ?, ?,  ?)");

            ps.setString(1, val.getInvoiceId().toString());
            ps.setDate(2, new java.sql.Date(val.getDt().getTime()));
            ps.setString(3, val.getCustomerId().toString());
            ps.setFloat(4, val.getTotal());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public InvoiceEntity loadFromResultSet(ResultSet rs) {
        InvoiceEntity result = null;
        try {
            if (rs.next()) {
                result = new InvoiceEntity();

                result.setInvoiceId(UUID.fromString(rs.getString("InvoiceId")));
                result.setDt(rs.getDate("Dt"));
                result.setCustomerId(UUID.fromString(rs.getString("CustomerId")));
                result.setTotal(rs.getFloat("Total"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<InvoiceEntity> get() throws SQLException {
        List<InvoiceEntity> result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  Invoice");

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
    public InvoiceEntity get(UUID id) throws SQLException {

        InvoiceEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from Invoice where InvoiceId=? ");

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
            deleteExecute(InvoiceEntity.TABLE, InvoiceEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}