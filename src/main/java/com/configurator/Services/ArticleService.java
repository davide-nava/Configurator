package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleEntity;
import com.configurator.Interfaces.IArticleService;

public class ArticleService extends BaseService implements IArticleService, IBaseService {

    @Override
    public void set(ArticleEntity val) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update Article set ArticleArticleGroupTypeId=?, ArticleGroupTypeId=?, ArticleId=?, Qta=? where ArticleArticleGroupTypeId=?");
            ps.setString(1, val.getArticleArticleGroupTypeId().toString());
            ps.setString(2, val.getArticleGroupTypeId().toString());
            ps.setString(3, val.getArticleGroupTypeId().toString());
            ps.setString(4, val.getArticleId().toString());
            ps.setFloat(5, val.getQta());

            into Article (ArticleId, Img, Doc, Code, Name, "Desc", ArticleTypeId, BasePrice

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }finally
        {
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
    public List<ArticleEntity> get() {
        List<ArticleEntity> result = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleId, Img, Doc, Code, Name, Desc, ArticleTypeId, BasePrice from  Article");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(new ArticleEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
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
    public ArticleEntity get(UUID id) {

        ArticleEntity result = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleId, Img, Doc, Code, Name, Desc, ArticleTypeId, BasePrice from  Article where ArticleId=? ");
            ps.setString(1, id.toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new ArticleEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
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
    public void delete(ArticleEntity val) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from Article where ArticleId=? ");
            ps.setString(1, val.getArticleId().toString());

            ps.executeUpdate();

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
            PreparedStatement ps = con.prepareStatement("delete from Article where ArticleId=? ");
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