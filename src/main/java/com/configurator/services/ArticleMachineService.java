package com.configurator.services;

import com.configurator.entities.ArticleMachineEntity;
import com.configurator.interfaces.IArticleMachineService;
import com.configurator.viewModels.ArticleMachineViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArticleMachineService extends BaseService implements IArticleMachineService {

    @Override
    public void update(ArticleMachineEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleMachine set  MachineId=?, ArticleId=?, Qta=?, Note=? where ArticleMachineId=?");

            ps.setString(1, val.getMachineId().toString().toUpperCase());
            ps.setString(2, val.getArticleId().toString().toUpperCase());
            ps.setFloat(3, val.getQta());
            ps.setString(4, val.getNote());

            ps.setString(5, val.getArticleMachineId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(ArticleMachineEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleMachine (ArticleMachineId, MachineId, ArticleId, Qta, Note) values ( ?, ?,?, ?, ?)");

            ps.setString(1, val.getArticleMachineId().toString().toUpperCase());
            ps.setString(2, val.getMachineId().toString().toUpperCase());
            ps.setString(3, val.getArticleId().toString().toUpperCase());
            ps.setFloat(4, val.getQta());
            ps.setString(5, val.getNote());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public ArticleMachineEntity loadEntityFromResultSet(ResultSet rs) {
        ArticleMachineEntity result = null;
        try {
            if (rs != null) {
                result = new ArticleMachineEntity();

                result.setArticleMachineId(UUID.fromString(rs.getString("ArticleMachineId")));
                result.setMachineId(UUID.fromString(rs.getString("MachineId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setQta(rs.getFloat("Qta"));
                result.setNote(rs.getString("Note"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public ArticleMachineViewModel loadViewModelFromResultSet(ResultSet rs) {
        ArticleMachineViewModel result = null;
        try {
            if (rs != null) {
                result = new ArticleMachineViewModel();

                result.setArticleMachineId(UUID.fromString(rs.getString("ArticleMachineId")));
                result.setMachineId(UUID.fromString(rs.getString("MachineId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setMachineDesc(rs.getString("MachineDesc"));
                result.setArticleDesc(rs.getString("ArticleDesc"));
                result.setQta(rs.getFloat("Qta"));
                result.setNote(rs.getString("Note"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<ArticleMachineViewModel> getViewModel() throws SQLException {
        List<ArticleMachineViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleMachine.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', Machine.Desc as 'MachineDesc' from ArticleMachine inner join Machine on Machine.MachineId = ArticleMachine.MachineId inner join Article on Article.ArticleId = ArticleMachine.ArticleId ");

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

        }
        return result;

    }

    @Override
    public ArticleMachineViewModel getViewModel(UUID id) throws SQLException {
        ArticleMachineViewModel result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleMachine.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', Machine.Desc as 'MachineDesc' from ArticleMachine inner join Machine on Machine.MachineId = ArticleMachine.MachineId inner join Article on Article.ArticleId = ArticleMachine.ArticleId where ArticleMachineId = ?");

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
    public List<ArticleMachineEntity> get() throws SQLException {
        List<ArticleMachineEntity> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  ArticleMachine");

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
    public ArticleMachineEntity get(UUID id) throws SQLException {

        ArticleMachineEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from ArticleMachine where ArticleMachineId=? ");

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
        deleteExecute(ArticleMachineEntity.TABLE, ArticleMachineEntity.PK, id);
    }

}