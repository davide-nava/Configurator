package com.configurator.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineTypeService extends BaseService implements IMachineTypeService{
 

    public static int save(User u) throws SQLException{
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into register(name,password,email,sex,country) values(?,?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSex());
            ps.setString(5, u.getCountry());
            status = ps.executeUpdate();
       } catch (SQLException exception) {
            printSQLException(exception);
        }
        return status;
    }

    public static int update(User u) throws SQLException{
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update register set name=?,password=?,email=?,sex=?,country=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSex());
            ps.setString(5, u.getCountry());
            ps.setInt(6, u.getId());
            status = ps.executeUpdate();
    } catch (SQLException exception) {
            printSQLException(exception);
        }
        return status;
    }

    public static int delete(User u) throws SQLException{
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from register where id=?");
            ps.setInt(1, u.getId());
            status = ps.executeUpdate();
     } catch (SQLException exception) {
            printSQLException(exception);
        }

        return status;
    }

    public static List<User> getAllRecords() throws SQLException{
        List<User> list = new ArrayList<User>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
                list.add(u);
            }
     } catch (SQLException exception) {
            printSQLException(exception);
        }
        return list;
    }

    public static User getRecordById(int id)throws SQLException {
        User u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
            }
    } catch (SQLException exception) {
            printSQLException(exception);
        }
        return u;
    }
}
