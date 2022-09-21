package com.configurator.Services;

import com.configurator.Entities.ArticleEntity;
import com.configurator.Interfaces.IArticleService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ArticleService extends BaseService implements IArticleService {

    @Override
    public void update(ArticleEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update Article set Img=?, Doc=?, Code=?, Name=?, Desc=?, ArticleTypeId=?, BasePrice=? where ArticleId=?");

            ps.setString(1, val.getImg());
            ps.setString(2, val.getDoc());
            ps.setString(3, val.getCode());
            ps.setString(4, val.getName());
            ps.setString(5, val.getDesc());
            ps.setString(6, val.getArticleTypeId().toString());
            ps.setFloat(7, val.getBasePrice());

            ps.setString(8, val.getArticleId().toString());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(ArticleEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into Article ( ArticleId, Img, Doc, Code, Name, Desc, ArticleTypeId, BasePrice) values ( ?, ?, ?,  ?, ? , ? ,? , ?)");

            ps.setString(1, val.getArticleId().toString());
            ps.setString(2, val.getImg());
            ps.setString(3, val.getDoc());
            ps.setString(4, val.getCode());
            ps.setString(5, val.getName());
            ps.setString(6, val.getDesc());
            ps.setString(7, val.getArticleTypeId().toString());
            ps.setFloat(8, val.getBasePrice());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public ArticleEntity loadFromResultSet(ResultSet rs) {
        ArticleEntity result = null;
        try {
            if (rs.next()) {
                result = new ArticleEntity();

                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setImg(rs.getString("Img"));
                result.setDoc(rs.getString("Doc"));
                result.setCode(rs.getString("Code"));
                result.setName(rs.getString("Name"));
                result.setDesc(rs.getString("Desc"));
                result.setArticleTypeId(UUID.fromString(rs.getString("ArticleTypeId")));
                result.setBasePrice(rs.getFloat("BasePrice"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<ArticleEntity> get() throws SQLException {
        List<ArticleEntity> result = null;
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
    public ArticleEntity get(UUID id) throws SQLException {

        ArticleEntity result = null;
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
            deleteExecute(ArticleEntity.TABLE, ArticleEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}