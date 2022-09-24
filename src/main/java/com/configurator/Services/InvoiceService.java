package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.InvoiceEntity;
import com.configurator.Entities.InvoiceViewModel;
import com.configurator.Interfaces.IInvoiceService;

public class InvoiceService extends BaseService implements IInvoiceService {

    @Override
    public void update(InvoiceEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update Invoice set     Dt=?, CustomerId=?, Total=? , Nr=? where InvoiceId=?");

            ps.setDate(1, new java.sql.Date(val.getDt().getTime()));
            ps.setString(2, val.getCustomerId().toString());
            ps.setFloat(3, val.getTotal());
            ps.setString(4, val.getNr());

            ps.setString(5, val.getInvoiceId().toString());

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
                    "insert into Invoice ( InvoiceId, Dt, CustomerId, Total, Nr) values ( ?, ?, ?,  ?, ?)");

            ps.setString(1, val.getInvoiceId().toString());
            ps.setDate(2, new java.sql.Date(val.getDt().getTime()));
            ps.setString(3, val.getCustomerId().toString());
            ps.setFloat(4, val.getTotal());
            ps.setString(5, val.getNr());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public InvoiceEntity loadEntityFromResultSet(ResultSet rs) {
        InvoiceEntity result = null;
        try {
            if (rs != null) {
                result = new InvoiceEntity();

                result.setInvoiceId(UUID.fromString(rs.getString("InvoiceId")));
                result.setDt(rs.getDate("Dt"));
                result.setCustomerId(UUID.fromString(rs.getString("CustomerId")));
                result.setTotal(rs.getFloat("Total"));
                result.setNr(rs.getString("Nr"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public InvoiceViewModel loadViewModelFromResultSet(ResultSet rs) {
        InvoiceViewModel result = null;
        try {
            if (rs != null) {
                result = new InvoiceViewModel();

                result.setInvoiceId(UUID.fromString(rs.getString("InvoiceId")));
                result.setDt(rs.getDate("Dt"));
                result.setCustomerId(UUID.fromString(rs.getString("CustomerId")));
                result.setTotal(rs.getFloat("Total"));
                result.setNr(rs.getString("Nr"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<InvoiceViewModel> getViewModal() throws SQLException {
        List<InvoiceViewModel> result = new ArrayList<InvoiceViewModel>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement( "select Invoice.*, (Customer.Name || ' - ' || Customer.Code ) as  'CustomerDesc' from Invoice inner join Customer on Customer.CustomerId = Invoice.CustomerId");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadViewModelFromResultSet(rs));
            }

        } catch (SQLException exception) {
            result = null;
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
    public List<InvoiceEntity> get() throws SQLException {
        List<InvoiceEntity> result = new ArrayList<InvoiceEntity>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  Invoice");

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
                result = loadEntityFromResultSet(rs);
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