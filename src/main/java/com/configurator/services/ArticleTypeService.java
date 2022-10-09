package com.configurator.services;

import com.configurator.entities.ArticleTypeEntity;
import com.configurator.interfaces.IArticleTypeService;
import com.configurator.viewModels.LookupViewModel;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArticleTypeService extends BaseService implements IArticleTypeService {

    @Override
    public void update(@NotNull ArticleTypeEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleType set   Desc=?,  Year=? where ArticleTypeId=?");

            ps.setString(1, val.getDesc());
            ps.setInt(2, val.getYear());

            ps.setString(3, val.getArticleTypeId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(@NotNull ArticleTypeEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleType ( ArticleTypeId, Desc,  Year) values ( ?, ?,  ?)");

            ps.setString(1, val.getArticleTypeId().toString().toUpperCase());
            ps.setString(2, val.getDesc());
            ps.setInt(3, val.getYear());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public ArticleTypeEntity loadEntityFromResultSet(ResultSet rs) {
        ArticleTypeEntity result = null;
        try {
            if (rs != null) {
                result = new ArticleTypeEntity();

                result.setArticleTypeId(UUID.fromString(rs.getString("ArticleTypeId")));
                result.setDesc(rs.getString("Desc"));
                result.setYear(rs.getInt("Year"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<ArticleTypeEntity> get() throws SQLException {
        List<ArticleTypeEntity> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  ArticleType");

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
    public ArticleTypeEntity get(@NotNull UUID id) throws SQLException {

        ArticleTypeEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from ArticleType where ArticleTypeId=? ");

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
        deleteExecute(ArticleTypeEntity.TABLE, ArticleTypeEntity.PK, id);
    }

    @Override
    public List<LookupViewModel> getLookupViewModel() throws SQLException {
        List<LookupViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(" select  ArticleTypeId as 'Id' ,  Desc  as 'Desc' from ArticleType");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadLookupFromResultSet(rs));
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
}
