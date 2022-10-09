package com.configurator.services;

import com.configurator.entities.ArticleEntity;
import com.configurator.interfaces.IArticleService;
import com.configurator.viewModels.ArticleViewModel;
import com.configurator.viewModels.LookupViewModel;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArticleService extends BaseService implements IArticleService {

    @Override
    public void update(@NotNull ArticleEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update Article set Doc=?, Code=?, Name=?, Desc=?, ArticleTypeId=?, BasePrice=?, IsMachine=? where ArticleId=?");

            ps.setString(1, val.getDoc());
            ps.setString(2, val.getCode());
            ps.setString(3, val.getName());
            ps.setString(4, val.getDesc());
            ps.setString(5, val.getArticleTypeId().toString().toUpperCase());
            ps.setFloat(6, val.getBasePrice());
            ps.setBoolean(7, val.getIsMachine());

            ps.setString(8, val.getArticleId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(@NotNull ArticleEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into Article ( ArticleId, Doc, Code, Name, Desc, ArticleTypeId, BasePrice, IsMachine) values (?, ?,  ?, ? , ? ,? , ?, ?)");

            ps.setString(1, val.getArticleId().toString().toUpperCase());
            ps.setString(2, val.getDoc());
            ps.setString(3, val.getCode());
            ps.setString(4, val.getName());
            ps.setString(5, val.getDesc());
            ps.setString(6, val.getArticleTypeId().toString().toUpperCase());
            ps.setFloat(7, val.getBasePrice());
            ps.setBoolean(8, val.getIsMachine());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public ArticleEntity loadEntityFromResultSet(ResultSet rs) {
        ArticleEntity result = null;
        try {
            if (rs != null) {
                result = new ArticleEntity();

                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setDoc(rs.getString("Doc"));
                result.setCode(rs.getString("Code"));
                result.setName(rs.getString("Name"));
                result.setDesc(rs.getString("Desc"));
                result.setArticleTypeId(UUID.fromString(rs.getString("ArticleTypeId")));
                result.setBasePrice(rs.getFloat("BasePrice"));
                result.setIsMachine(rs.getBoolean("IsMachine"));

            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public ArticleViewModel loadViewModelFromResultSet(ResultSet rs) {
        ArticleViewModel result = null;
        try {
            if (rs != null) {
                result = new ArticleViewModel();

                result.setArticleId(UUID.fromString(rs.getString("ArticleId")));
                result.setDoc(rs.getString("Doc"));
                result.setCode(rs.getString("Code"));
                result.setName(rs.getString("Name"));
                result.setDesc(rs.getString("Desc"));
                result.setArticleTypeId(UUID.fromString(rs.getString("ArticleTypeId")));
                result.setArticleTypeDesc(rs.getString("ArticleTypeDesc"));
                result.setBasePrice(rs.getFloat("BasePrice"));
                result.setIsMachine(rs.getBoolean("IsMachine"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<ArticleViewModel> getViewModel() throws SQLException {
        List<ArticleViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    " select Article.*  , ArticleType.Desc as 'ArticleTypeDesc' from Article inner join ArticleType on ArticleType.ArticleTypeId = Article.ArticleTypeId    ");

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
    public ArticleViewModel getViewModel(@NotNull UUID id) throws SQLException {
        ArticleViewModel result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    " select Article.*  , ArticleType.Desc as 'ArticleTypeDesc' from Article inner join ArticleType on ArticleType.ArticleTypeId = Article.ArticleTypeId  where ArticleId=?   ");

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
    public List<ArticleEntity> get() throws SQLException {
        List<ArticleEntity> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  Article");

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
    public ArticleEntity get(@NotNull UUID id) throws SQLException {

        ArticleEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from Article where ArticleId=? ");

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
        deleteExecute(ArticleEntity.TABLE, ArticleEntity.PK, id);
    }

    @Override
    public List<LookupViewModel> getLookupViewModel() throws SQLException {
        List<LookupViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(" select  ArticleId as 'Id' ,  Code  as 'Desc' from Article");

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
