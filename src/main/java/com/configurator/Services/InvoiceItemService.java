package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.InvoiceItemEntity;
import com.configurator.Entities.InvoiceItemViewModel;
import com.configurator.Interfaces.IInvoiceItemService;

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
    public InvoiceItemEntity loadEntityFromResultSet(ResultSet rs) {
        InvoiceItemEntity result = null;
        try {
            if (rs != null) {
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
    public InvoiceItemViewModel loadViewModelFromResultSet(ResultSet rs) {
        InvoiceItemViewModel result = null;
        try {
            if (rs != null) {
                result = new InvoiceItemViewModel();

                result.setInvoiceItemId(UUID.fromString(rs.getString("InvoiceItemId")));
                result.setInvoiceId(UUID.fromString(rs.getString("InvoiceId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setMachineId(UUID.fromString(rs.getString("MachineId")));
                result.setInvoiceDesc(rs.getString("InvoiceDesc"));
                result.setArticleDesc(rs.getString("ArticleDesc"));
                result.setMachineDesc(rs.getString("MachineDesc"));
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
    public List<InvoiceItemViewModel> getViewModal() throws SQLException {
        List<InvoiceItemViewModel> result = new ArrayList<InvoiceItemViewModel>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement( "select InvoiceItem.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', Invoice.Nr as 'InvoiceDesc' , Machine.Desc as 'MachineDesc' from InvoiceItem inner join Invoice on Invoice.InvoiceId = InvoiceItem.InvoiceId inner join Article on Article.ArticleId = InvoiceItem.ArticleId   inner join Machine on Machine.MachineId = InvoiceItem.MachineId ");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadViewModelFromResultSet(rs));
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
    public List<InvoiceItemEntity> get() throws SQLException {
        List<InvoiceItemEntity> result = new ArrayList<InvoiceItemEntity>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  InvoiceItem");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadEntityFromResultSet(rs));
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
            deleteExecute(InvoiceItemEntity.TABLE, InvoiceItemEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

}