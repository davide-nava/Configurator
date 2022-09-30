package com.configurator.Services;

import com.configurator.Entities.MachineTypeEntity;
import com.configurator.Interfaces.IMachineTypeService;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MachineTypeService extends BaseService implements IMachineTypeService {

    @Override
    public void update(MachineTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update MachineType set   Desc=?, Code=?, Dt=?, Nr=?, Img=?, Axes=?, Cnc=?, Note=?, Spindles=? where MachineTypeId=?");

            ps.setString(1, val.getDesc());
            ps.setString(2, val.getCode());
            ps.setDate(3, new java.sql.Date(val.getDt().getTime()));
            ps.setString(4, val.getNr());
            ps.setString(5, val.getImg());
            ps.setInt(6, val.getAxes());
            ps.setString(7, val.getCnc());
            ps.setString(8, val.getNote());
            ps.setInt(9, val.getSpindles());

            ps.setString(10, val.getMachineTypeId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void insert(MachineTypeEntity val) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into MachineType ( MachineTypeId, Desc, Code, Dt, Nr, Img, Axes, Cnc, Note, Spindles) values ( ?, ?, ?,  ?,?,?,?,?,?,?)");

            ps.setString(1, val.getMachineTypeId().toString().toUpperCase());
            ps.setString(2, val.getDesc());
            ps.setString(3, val.getCode());
            ps.setDate(4, new java.sql.Date(val.getDt().getTime()));
            ps.setString(5, val.getNr());
            ps.setString(6, val.getImg());
            ps.setInt(7, val.getAxes());
            ps.setString(8, val.getCnc());
            ps.setString(9, val.getNote());
            ps.setInt(10, val.getSpindles());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public MachineTypeEntity loadEntityFromResultSet(ResultSet rs) {
        MachineTypeEntity result = null;
        try {
            if (rs != null) {
                result = new MachineTypeEntity();

                result.setMachineTypeId(UUID.fromString(rs.getString("MachineTypeId")));
                result.setDesc(rs.getString("Desc"));
                result.setCode(rs.getString("Code"));
                result.setNr(rs.getString("Nr"));
                result.setImg(rs.getString("Img"));
                result.setAxes(rs.getInt("Axes"));
                result.setSpindles(rs.getInt("Spindles"));
                result.setCnc(rs.getString("Cnc"));
                result.setNote(rs.getString("Note"));
                result.setDt(rs.getDate("Dt"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        } finally {
            return result;
        }
    }

    @Override
    public List<MachineTypeEntity> get() throws SQLException {
        List<MachineTypeEntity> result = new ArrayList<MachineTypeEntity>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select MachineTypeId, Desc, Code, Dt, Nr, Img, Axes, Cnc, Note, Spindles from MachineType");

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
    public MachineTypeEntity get(UUID id) throws SQLException {

        MachineTypeEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select MachineTypeId, Desc, Code, Dt, Nr, Img, Axes, Cnc, Note, Spindles from MachineType where MachineTypeId=? ");

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
            deleteExecute(MachineTypeEntity.TABLE, MachineTypeEntity.PK, id);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public List<LookupViewModel> getLookupViewModel() throws SQLException {
        List<LookupViewModel> result = new ArrayList<LookupViewModel>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select  MachineTypeId as 'Id', Code as 'Desc' from  MachineType");

            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(loadLookupFromResultSet(rs));
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
}