package com.configurator.Services;

import com.configurator.Entities.ArticleMachineTypeEntity;
import com.configurator.Interfaces.IArticleMachineTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ArticleMachineTypeService extends BaseService implements IArticleMachineTypeService {

    @Override
    public void update(ArticleMachineTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleMachineType set   ArticleId=?, MachineTypeId=?, Qta=? where ArticleMachineTypeId=?");

            ps.setString(1, val.getArticleId().toString());
            ps.setString(2, val.getMachineTypeId().toString());
            ps.setFloat(3, val.getQta());

            ps.setString(4, val.getArticleMachineTypeId().toString());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(ArticleMachineTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleMachineType ( ArticleMachineTypeId, ArticleId, MachineTypeId, Qta) values ( ?, ?, ?,  ?)");

            ps.setString(1, val.getArticleMachineTypeId().toString());
            ps.setString(2, val.getArticleId().toString());
            ps.setString(3, val.getMachineTypeId().toString());
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
    public ArticleMachineTypeEntity loadFromResultSet(ResultSet rs) {
        ArticleMachineTypeEntity result = null;
        try {
            if (rs.next()) {
                result = new ArticleMachineTypeEntity();

                result.setArticleMachineTypeId(UUID.fromString(rs.getString("ArticleMachineTypeId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setMachineTypeId(UUID.fromString(rs.getString("MachineTypeId")));
                result.setQta(rs.getFloat("Qta"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<ArticleMachineTypeEntity> get() throws SQLException {
        List<ArticleMachineTypeEntity> result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  ArticleMachine");

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
    public ArticleMachineTypeEntity get(UUID id) throws SQLException {

        ArticleMachineTypeEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from ArticleMachineType where ArticleMachineTypeId=? ");

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
            deleteExecute(ArticleMachineTypeEntity.TABLE, ArticleMachineTypeEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}