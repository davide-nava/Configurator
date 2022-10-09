package com.configurator.services;

import com.configurator.entities.ArticleMachineTypeEntity;
import com.configurator.interfaces.IArticleMachineTypeService;
import com.configurator.viewModels.ArticleMachineTypeViewModel;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArticleMachineTypeService extends BaseService implements IArticleMachineTypeService {

    @Override
    public void update(@NotNull ArticleMachineTypeEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleMachineType set   ArticleId=?, MachineTypeId=?, Qta=? where ArticleMachineTypeId=?");

            ps.setString(1, val.getArticleId().toString().toUpperCase());
            ps.setString(2, val.getMachineTypeId().toString().toUpperCase());
            ps.setFloat(3, val.getQta());

            ps.setString(4, val.getArticleMachineTypeId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(@NotNull ArticleMachineTypeEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleMachineType ( ArticleMachineTypeId, ArticleId, MachineTypeId, Qta) values ( ?, ?, ?,  ?)");

            ps.setString(1, val.getArticleMachineTypeId().toString().toUpperCase());
            ps.setString(2, val.getArticleId().toString().toUpperCase());
            ps.setString(3, val.getMachineTypeId().toString().toUpperCase());
            ps.setFloat(4, val.getQta());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public ArticleMachineTypeEntity loadEntityFromResultSet(ResultSet rs) {
        ArticleMachineTypeEntity result = null;
        try {
            if (rs != null) {
                result = new ArticleMachineTypeEntity();

                result.setArticleMachineTypeId(UUID.fromString(rs.getString("ArticleMachineTypeId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setMachineTypeId(UUID.fromString(rs.getString("MachineTypeId")));
                result.setQta(rs.getFloat("Qta"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public ArticleMachineTypeViewModel loadViewModelFromResultSet(ResultSet rs) {
        ArticleMachineTypeViewModel result = null;
        try {
            if (rs != null) {
                result = new ArticleMachineTypeViewModel();

                result.setArticleMachineTypeId(UUID.fromString(rs.getString("ArticleMachineTypeId")));
                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setMachineTypeId(UUID.fromString(rs.getString("MachineTypeId")));
                result.setArticleDesc(rs.getString("ArticleDesc"));
                result.setMachineTypeDesc(rs.getString("MachineTypeDesc"));
                result.setQta(rs.getFloat("Qta"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<ArticleMachineTypeViewModel> getViewModel() throws SQLException {
        List<ArticleMachineTypeViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleMachineType.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', MachineType.Desc as 'MachineTypeDesc' from ArticleMachineType inner join MachineType on MachineType.MachineTypeId = ArticleMachineType.MachineTypeId  inner join Article on Article.ArticleId = ArticleMachineType.ArticleId ");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadViewModelFromResultSet(rs));
            }

        } catch (SQLException exception) {
            result = null;
            printSQLException(exception);
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return result;

    }

    @Override
    public ArticleMachineTypeViewModel getViewModel(@NotNull UUID id) throws SQLException {
        ArticleMachineTypeViewModel result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleMachineType.*, (Article.Name || ' - ' || Article.Code ) as  'ArticleDesc', MachineType.Desc as 'MachineTypeDesc' from ArticleMachineType inner join MachineType on MachineType.MachineTypeId = ArticleMachineType.MachineTypeId  inner join Article on Article.ArticleId = ArticleMachineType.ArticleId where ArticleMachineTypeId=?");

            ps.setString(1, id.toString().toUpperCase());

            rs = ps.executeQuery();

            if (rs.next()) {
                result = loadViewModelFromResultSet(rs);
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return result;
    }

    @Override
    public List<ArticleMachineTypeEntity> get() throws SQLException {
        List<ArticleMachineTypeEntity> result = new ArrayList<>();
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
            result = null;
            printSQLException(exception);
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return result;

    }

    @Override
    public ArticleMachineTypeEntity get(@NotNull UUID id) throws SQLException {

        ArticleMachineTypeEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from ArticleMachineType where ArticleMachineTypeId=? ");

            ps.setString(1, id.toString().toUpperCase());

            rs = ps.executeQuery();

            if (rs.next()) {
                result = loadEntityFromResultSet(rs);
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return result;

    }

    @Override
    public void delete(UUID id) {
        deleteExecute(ArticleMachineTypeEntity.TABLE, ArticleMachineTypeEntity.PK, id);
    }

}
