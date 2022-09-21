package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.javatpoint.bean.InvoiceEntity;

public class InvoiceService extends BaseService implements IInvoiceService, IBaseService {

    @Override
    public void set(InvoiceEntity val) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update ArticleArticleGroupType set ArticleArticleGroupTypeId=?, ArticleGroupTypeId=?, ArticleId=?, Qta=? where ArticleArticleGroupTypeId=?");
            ps.setString(1, val.getArticleArticleGroupTypeId().toString());
            ps.setString(2, val.getArticleGroupTypeId().toString());
            ps.setString(3, val.getArticleGroupTypeId().toString());
            ps.setString(4, val.getArticleId().toString());
            ps.setFloat(5, val.getQta());

            ps.executeUpdate();

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
    public ArticleArticleGroupTypeEntity loadFromResultSet(ResultSet val) {
        ArticleArticleGroupTypeEntity result = null;
        try {
            if (rs.next()) {
                result = new ArticleArticleGroupTypeEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
                        UUID.fromString(rs.getString("articleGroupTypeId")), UUID.fromString(rs.getString("articleId")),
                        rs.getFloat("qta"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<InvoiceEntity> get() {
        List<InvoiceEntity> result = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleArticleGroupTypeId, ArticleGroupTypeId, ArticleId, Qta from  ArticleArticleGroupType");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(new InvoiceEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
                        UUID.fromString(rs.getString("articleGroupTypeId")), UUID.fromString(rs.getString("articleId")),
                        rs.getFloat("qta")));
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
    public InvoiceEntity get(UUID id) {

        InvoiceEntity result = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleArticleGroupTypeId, ArticleGroupTypeId, ArticleId, Qta from  ArticleArticleGroupType where ArticleArticleGroupTypeId=? ");
            // PreparedStatement ps = con.prepareStatement("update register set
            // name=?,password=?,email=?,sex=?,country=? where id=?");
            ps.setString(1, id.toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new InvoiceEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
                        UUID.fromString(rs.getString("articleGroupTypeId")), UUID.fromString(rs.getString("articleId")),
                        rs.getFloat("qta"));
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
    public void delete(InvoiceEntity val) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con
                    .prepareStatement("delete from ArticleArticleGroupType where ArticleArticleGroupTypeId=? ");
            // PreparedStatement ps = con.prepareStatement("update register set
            // name=?,password=?,email=?,sex=?,country=? where id=?");
            ps.setString(1, val.getArticleArticleGroupTypeId().toString());

            ps.executeUpdate();

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
            Connection con = getConnection();
            PreparedStatement ps = con
                    .prepareStatement("delete from ArticleArticleGroupType where ArticleArticleGroupTypeId=? ");
            ps.setString(1, id.toString());

            ps.executeUpdate();

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
}