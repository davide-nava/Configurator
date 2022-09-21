package com.configurator.Services;

import com.configurator.Entities.InvoiceItemEntity;
import com.configurator.Interfaces.IInvoiceItemService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class InvoiceItemService extends BaseService implements IInvoiceItemService {


    @Override
    public void update(InvoiceItemEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update InvoiceItem set  Dt=?, InvoiceId=?, ArticleId=?, MachineId=?, Qta=? where InvoiceItemId=?");

            ps.setDate(1, new java.sql.Date(val.getDt().getTime()));
            ps.setString(2, val.getInvoiceId().toString());
            ps.setString(3, val.getArticleId().toString());
            ps.setString(3, val.getMachineId().toString());
            ps.setFloat(3, val.getQta());

            ps.setString(6, val.getInvoiceItemId().toString());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(InvoiceItemEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into InvoiceItem ( InvoiceItemId, Dt, InvoiceId, ArticleId, MachineId, Qta) values ( ?, ?, ?,  ?,?,?)");

            ps.setString(1, val.getInvoiceItemId().toString());
            ps.setDate(2, new java.sql.Date(val.getDt().getTime()));
            ps.setString(3, val.getInvoiceId().toString());
            ps.setString(4, val.getArticleId().toString());
            ps.setString(5, val.getMachineId().toString());
            ps.setFloat(6, val.getQta());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public InvoiceItemEntity loadFromResultSet(ResultSet rs) {
        InvoiceItemEntity result = null;
        try {
            if (rs.next()) {
                result = new InvoiceItemEntity();

                result.setInvoiceItemId(UUID.fromString(rs.getString("InvoiceItemId")));
                result.setInvoiceId(UUID.fromString(rs.getString("InvoiceId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setMachineId(UUID.fromString(rs.getString("MachineId")));
                result.setQta(rs.getFloat("Qta"));
                result.setDt(rs.getDate("Dt"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<InvoiceItemEntity> get() throws SQLException {
        List<InvoiceItemEntity> result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  InvoiceItem");

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
    public InvoiceItemEntity get(UUID id) throws SQLException {

        InvoiceItemEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from InvoiceItem where InvoiceItemId=? ");

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
            deleteExecute(InvoiceItemEntity.TABLE, InvoiceItemEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}