package com.configurator.services;

import com.configurator.entities.MachineEntity;
import com.configurator.interfaces.IMachineService;
import com.configurator.viewModels.LookupViewModel;
import com.configurator.viewModels.MachineViewModel;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MachineService extends BaseService implements IMachineService {

    @Override
    public void update(@NotNull MachineEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "update Machine set Nr=?, Year=?, Code=?, Desc=?, Doc=?, MachineTypeId=?, BasePrice=?, Note=?, ProductionOrder=?,  Address=?, DtDelivery=?, DtAcceptance=?, DtEndWarranty=?, DtStartWarranty=? where MachineId=?");

            ps.setInt(1, val.getNr());
            ps.setInt(2, val.getYear());
            ps.setString(3, val.getCode());
            ps.setString(4, val.getDesc());
            ps.setString(5, val.getDoc());
            ps.setString(6, val.getMachineTypeId().toString().toUpperCase());
            ps.setFloat(7, val.getBasePrice());
            ps.setString(8, val.getNote());
            ps.setString(9, val.getProductionOrder());
            ps.setString(10, val.getAddress());
            ps.setDate(11, new java.sql.Date(val.getDtDelivery().getTime()));
            ps.setDate(12, new java.sql.Date(val.getDtAcceptance().getTime()));
            ps.setDate(13, new java.sql.Date(val.getDtEndWarranty().getTime()));
            ps.setDate(14, new java.sql.Date(val.getDtStartWarranty().getTime()));

            ps.setString(15, val.getMachineId().toString().toUpperCase());

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void insert(@NotNull MachineEntity val) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "insert into Machine ( MachineId, Nr, Year, Code, Desc, Doc, MachineTypeId, BasePrice, Note, ProductionOrder,  Address, DtDelivery, DtAcceptance, DtEndWarranty, DtStartWarranty) values ( ?, ?, ?,  ?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, val.getMachineId().toString().toUpperCase());
            ps.setInt(2, val.getNr());
            ps.setInt(3, val.getYear());
            ps.setString(4, val.getCode());
            ps.setString(5, val.getDesc());
            ps.setString(6, val.getDoc());
            ps.setString(7, val.getMachineTypeId().toString().toUpperCase());
            ps.setFloat(8, val.getBasePrice());
            ps.setString(9, val.getNote());
            ps.setString(10, val.getProductionOrder());
            ps.setString(11, val.getAddress());
            ps.setDate(12, new java.sql.Date(val.getDtDelivery().getTime()));
            ps.setDate(13, new java.sql.Date(val.getDtAcceptance().getTime()));
            ps.setDate(14, new java.sql.Date(val.getDtEndWarranty().getTime()));
            ps.setDate(15, new java.sql.Date(val.getDtStartWarranty().getTime()));

            ps.executeUpdate();

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public MachineEntity loadEntityFromResultSet(ResultSet rs) {
        MachineEntity result = null;
        try {
            if (rs != null) {
                result = new MachineEntity();

                result.setMachineId(UUID.fromString(rs.getString("MachineId")));
                result.setMachineTypeId(UUID.fromString(rs.getString("MachineTypeId")));
                result.setDesc(rs.getString("Desc"));
                result.setYear(rs.getInt("Year"));
                result.setDoc(rs.getString("Doc"));
                result.setCode(rs.getString("Code"));
                result.setNr(rs.getInt("Nr"));
                result.setBasePrice(rs.getFloat("BasePrice"));
                result.setNote(rs.getString("Note"));
                result.setProductionOrder(rs.getString("ProductionOrder"));
                result.setAddress(rs.getString("Address"));
                result.setDtDelivery(rs.getDate("DtDelivery"));
                result.setDtAcceptance(rs.getDate("DtAcceptance"));
                result.setDtEndWarranty(rs.getDate("DtEndWarranty"));
                result.setDtStartWarranty(rs.getDate("DtStartWarranty"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public MachineViewModel loadViewModelFromResultSet(ResultSet rs) {
        MachineViewModel result = null;
        try {
            if (rs != null) {
                result = new MachineViewModel();

                result.setMachineId(UUID.fromString(rs.getString("MachineId")));
                result.setMachineTypeId(UUID.fromString(rs.getString("MachineTypeId")));
                result.setMachineTypeDesc(rs.getString("MachineTypeDesc"));
                result.setDesc(rs.getString("Desc"));
                result.setYear(rs.getInt("Year"));
                result.setDoc(rs.getString("Doc"));
                result.setCode(rs.getString("Code"));
                result.setNr(rs.getInt("Nr"));
                result.setBasePrice(rs.getFloat("BasePrice"));
                result.setNote(rs.getString("Note"));
                result.setProductionOrder(rs.getString("ProductionOrder"));
                result.setAddress(rs.getString("Address"));
                result.setDtDelivery(rs.getDate("DtDelivery"));
                result.setDtAcceptance(rs.getDate("DtAcceptance"));
                result.setDtEndWarranty(rs.getDate("DtEndWarranty"));
                result.setDtStartWarranty(rs.getDate("DtStartWarranty"));
            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return result;
    }

    @Override
    public List<MachineViewModel> getViewModel() throws SQLException {
        List<MachineViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select Machine.*,   MachineType.Desc as 'MachineTypeDesc'  from  Machine inner join MachineType on MachineType.MachineTypeId = Machine.MachineTypeId");

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
    public MachineViewModel getViewModel(@NotNull UUID id) throws SQLException {
        MachineViewModel result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select Machine.*,   MachineType.Desc as 'MachineTypeDesc'  from  Machine inner join MachineType on MachineType.MachineTypeId = Machine.MachineTypeId where MachineId=? ");

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
    public List<MachineEntity> get() throws SQLException {
        List<MachineEntity> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from  Machine");

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
    public MachineEntity get(@NotNull UUID id) throws SQLException {

        MachineEntity result = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from Machine where MachineId=? ");

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
        deleteExecute(MachineEntity.TABLE, MachineEntity.PK, id);
    }

    @Override
    public List<LookupViewModel> getLookupViewModel() throws SQLException {
        List<LookupViewModel> result = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select  MachineId as 'Id', Code as 'Desc' from  Machine");

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
