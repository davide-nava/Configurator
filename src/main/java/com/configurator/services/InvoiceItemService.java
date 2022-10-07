package com.configurator.services;

import com.configurator.entities.InvoiceItemEntity;
import com.configurator.interfaces.IInvoiceItemService;
import com.configurator.viewModels.InvoiceItemViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvoiceItemService extends BaseService implements IInvoiceItemService {

    @Override
    public void update(InvoiceItemEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update InvoiceItem set  Dt=?, InvoiceId=?, ArticleId=?,  Qta=? where InvoiceItemId=?");

            ps.setDate(1, new java.sql.Date(val.getDt().getTime()));
            ps.setString(2, val.getInvoiceId().toString().toUpperCase());
            ps.setString(3, val.getArticleId().toString().toUpperCase());
            ps.setFloat(4, val.getQta());

            ps.setString(5, val.getInvoiceItemId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(InvoiceItemEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into InvoiceItem ( InvoiceItemId, Dt, InvoiceId, ArticleId,  Qta) values ( ?, ?, ?, ?,?)");

            ps.setString(1, val.getInvoiceItemId().toString().toUpperCase());
            ps.setDate(2, new java.sql.Date(val.getDt().getTime()));
            ps.setString(3, val.getInvoiceId().toString().toUpperCase());
            ps.setString(4, val.getArticleId().toString().toUpperCase());
            ps.setFloat(5, val.getQta());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
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
                result.setQta(rs.getFloat("Qta"));
                result.setDt(new java.sql.Date(rs.getDate("Dt").getTime()));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
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
                result.setInvoiceDesc(rs.getString("InvoiceDesc"));
                result.setArticleDesc(rs.getString("ArticleDesc"));
                result.setQta(rs.getFloat("Qta"));
                result.setDt(rs.getDate("Dt"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<InvoiceItemViewModel> getViewModel() throws SQLException {
        List<InvoiceItemViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select InvoiceItem.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', Invoice.Nr as 'InvoiceDesc'  from InvoiceItem inner join Invoice on Invoice.InvoiceId = InvoiceItem.InvoiceId inner join Article on Article.ArticleId = InvoiceItem.ArticleId   ");

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

        }
        return result;

    }

    @Override
    public InvoiceItemViewModel getViewModel(UUID id) throws SQLException {
        InvoiceItemViewModel result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select InvoiceItem.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', Invoice.Nr as 'InvoiceDesc'  from InvoiceItem inner join Invoice on Invoice.InvoiceId = InvoiceItem.InvoiceId inner join Article on Article.ArticleId = InvoiceItem.ArticleId  where InvoiceItemId =? ");

            ps.setString(1, id.toString().toUpperCase());

            rs = ps.executeQuery();

            if (rs.next()) {
                result = loadViewModelFromResultSet(rs);
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
    public List<InvoiceItemEntity> get() throws SQLException {
        List<InvoiceItemEntity> result = new ArrayList<>();
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
        }
        return result;

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
        deleteExecute(InvoiceItemEntity.TABLE, InvoiceItemEntity.PK, id);
    }

}