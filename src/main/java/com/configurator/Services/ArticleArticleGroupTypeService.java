package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Interfaces.IArticleArticleGroupTypeService;
import com.configurator.ViewModels.ArticleArticleGroupTypeViewModel;

public class ArticleArticleGroupTypeService extends BaseService
        implements IArticleArticleGroupTypeService {

    @Override
    public void update(ArticleArticleGroupTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleArticleGroupType set ArticleGroupTypeId=?, ArticleId=?, Qta=? where ArticleArticleGroupTypeId=?");

            ps.setString(1, val.getArticleGroupTypeId().toString().toUpperCase());
            ps.setString(2, val.getArticleId().toString().toUpperCase());
            ps.setFloat(3, val.getQta());

            ps.setString(4, val.getArticleArticleGroupTypeId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(ArticleArticleGroupTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleArticleGroupType (ArticleArticleGroupTypeId, ArticleGroupTypeId, ArticleId, Qta) values ( ?, ?,?, ?)");

            ps.setString(1, val.getArticleArticleGroupTypeId().toString().toUpperCase());
            ps.setString(2, val.getArticleGroupTypeId().toString().toUpperCase());
            ps.setString(3, val.getArticleId().toString().toUpperCase());
            ps.setFloat(4, val.getQta());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public ArticleArticleGroupTypeEntity loadEntityFromResultSet(ResultSet rs) {
        ArticleArticleGroupTypeEntity result = null;

        try {
            if (rs != null) {
                result = new ArticleArticleGroupTypeEntity();

                result.setArticleGroupTypeId(UUID.fromString(rs.getString("ArticleGroupTypeId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setQta(rs.getFloat("Qta"));
            }
        } catch (Exception ex) {
            result = null;
            throw ex;
        } finally {
            return result;
        }
    }

    @Override
    public ArticleArticleGroupTypeViewModel loadViewModelFromResultSet(ResultSet rs) {
        ArticleArticleGroupTypeViewModel result = null;

        try {
            if (rs != null) {
                result = new ArticleArticleGroupTypeViewModel();

                result.setArticleArticleGroupTypeId(UUID.fromString(rs.getString("ArticleArticleGroupTypeId")));
                result.setArticleGroupTypeId(UUID.fromString(rs.getString("ArticleGroupTypeId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setArticleDesc(rs.getString("ArticleDesc"));
                result.setArticleGroupTypeDesc(rs.getString("ArticleGroupTypeDesc"));
                result.setQta(rs.getFloat("Qta"));
            }
        } catch (Exception ex) {
            result = null;
            throw ex;
        } finally {
            return result;
        }
    }

    @Override
    public List<ArticleArticleGroupTypeViewModel> getViewModel() throws SQLException {
        List<ArticleArticleGroupTypeViewModel> result = new ArrayList<ArticleArticleGroupTypeViewModel>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    " select ArticleArticleGroupType.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', ArticleGroupType.Desc as 'ArticleGroupTypeDesc' from ArticleArticleGroupType inner join Article on Article.ArticleId = ArticleArticleGroupType.ArticleId inner join ArticleGroupType on ArticleGroupType.ArticleGroupTypeId = ArticleArticleGroupType.ArticleGroupTypeId  ");

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
    public List<ArticleArticleGroupTypeEntity> get() throws SQLException {
        List<ArticleArticleGroupTypeEntity> result = new ArrayList<ArticleArticleGroupTypeEntity>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from  ArticleArticleGroupType");

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
    public ArticleArticleGroupTypeEntity get(UUID id) throws SQLException {

        ArticleArticleGroupTypeEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  ArticleArticleGroupType where ArticleArticleGroupTypeId=? ");
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

            return result;
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            deleteExecute(ArticleArticleGroupTypeEntity.TABLE, ArticleArticleGroupTypeEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}