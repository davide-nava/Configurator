package com.configurator.Services;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Interfaces.IArticleTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArticleTypeService extends BaseService implements IArticleTypeService {

    @Override
    public void update(ArticleTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update ArticleType set   Desc=?, Code=?, Year=? where ArticleTypeId=?");

            ps.setString(1, val.getDesc());
            ps.setString(2, val.getCode());
            ps.setInt(3, val.getYear());

            ps.setString(4, val.getArticleTypeId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(ArticleTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into ArticleType ( ArticleTypeId, Desc, Code, Year) values ( ?, ?, ?,  ?)");

            ps.setString(1, val.getArticleTypeId().toString().toUpperCase());
            ps.setString(2, val.getDesc());
            ps.setString(3, val.getCode());
            ps.setInt(4, val.getYear());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
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
                result.setCode(rs.getString("Code"));
                result.setYear(rs.getInt("Year"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<ArticleTypeEntity> get() throws SQLException {
        List<ArticleTypeEntity> result = new ArrayList<ArticleTypeEntity>();
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
            if (rs != null)
                rs.close();

            if (con != null)
                con.close();

            return result;
        }
    }

    @Override
    public ArticleTypeEntity get(UUID id) throws SQLException {

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
            deleteExecute(ArticleTypeEntity.TABLE, ArticleTypeEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

}