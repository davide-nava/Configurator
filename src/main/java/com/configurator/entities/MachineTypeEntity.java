package com.configurator.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class MachineTypeEntity implements Serializable {

    public static final String PK = "MachineTypeId";
    public static final String TABLE = "MachineType";
    private UUID machineTypeId;
    private String desc = "";
    private String code = "";
    private String nr = "";
    private Date dt;
    private int axes = 1;
    private String cnc = "";
    private String note = "";
    private int spindles = 1;

    public UUID getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(UUID machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCnc() {
        return cnc;
    }

    public void setCnc(String cnc) {
        this.cnc = cnc;
    }

    public int getSpindles() {
        return spindles;
    }

    public void setSpindles(int spindles) {
        this.spindles = spindles;
    }

    public int getAxes() {
        return axes;
    }

    public void setAxes(int axes) {
        this.axes = axes;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

}
