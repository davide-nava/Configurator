package com.configurator.Services;

import com.configurator.Entities.ArticleGroupTypeEntity;
import com.configurator.Interfaces.IArticleGroupTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ArticleGroupTypeService extends BaseService implements IArticleGroupTypeService {

    @Override
    public void update(ArticleGroupTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleGroupType set Code=?, Desc=?, ProductionOrder=? where ArticleGroupTypeId=?");

            ps.setString(1, val.getCode());
            ps.setString(2, val.getDesc());
            ps.setString(3, val.getProductionOrder());

            ps.setString(4, val.getArticleGroupTypeId().toString());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(ArticleGroupTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleGroupType (ArticleGroupTypeId, Code, Desc, ProductionOrder) values ( ?, ?,?, ?)");

            ps.setString(1, val.getArticleGroupTypeId().toString());
            ps.setString(2, val.getCode());
            ps.setString(3, val.getDesc());
            ps.setString(4, val.getProductionOrder());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public ArticleGroupTypeEntity loadFromResultSet(ResultSet rs) {
        ArticleGroupTypeEntity result = null;
        try {
            if (rs.next()) {
                result = new ArticleGroupTypeEntity();

                result.setArticleGroupTypeId(UUID.fromString(rs.getString("ArticleGroupTypeId")));
                result.setCode(rs.getString("Code"));
                result.setDesc(rs.getString("Desc"));
                result.setProductionOrder(rs.getString("ProductionOrder"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<ArticleGroupTypeEntity> get() throws SQLException {
        List<ArticleGroupTypeEntity> result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  ArticleGroupType");

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
    public ArticleGroupTypeEntity get(UUID id) throws SQLException {

        ArticleGroupTypeEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  ArticleGroupType where ArticleGroupTypeId=? ");
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
            deleteExecute(ArticleGroupTypeEntity.TABLE, ArticleGroupTypeEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}