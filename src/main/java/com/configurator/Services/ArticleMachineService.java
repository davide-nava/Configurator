package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Entities.ArticleGroupTypeEntity;
import com.configurator.Entities.ArticleMachineEntity;

public class ArticleMachineService extends BaseService implements IArticleMachineService {

    @Override
    public void set(ArticleGroupTypeEntity val) {
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
    public List<ArticleGroupTypeEntity> get() {
        List<ArticleGroupTypeEntity> result = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleArticleGroupTypeId, ArticleGroupTypeId, ArticleId, Qta from  ArticleArticleGroupType");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(new ArticleGroupTypeEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
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
    public ArticleGroupTypeEntity get(UUID id) {

        ArticleGroupTypeEntity result = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select ArticleArticleGroupTypeId, ArticleGroupTypeId, ArticleId, Qta from  ArticleArticleGroupType where ArticleArticleGroupTypeId=? ");
            // PreparedStatement ps = con.prepareStatement("update register set
            // name=?,password=?,email=?,sex=?,country=? where id=?");
            ps.setString(1, id.toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new ArticleArticleGroupTypeEntity(UUID.fromString(rs.getString("articleArticleGroupTypeId")),
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
    public void delete(UUID id) {
        try {
            deleteExecute( ArticleMachineEntity.TABLE,ArticleMachineEntity.PK,  id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }
}