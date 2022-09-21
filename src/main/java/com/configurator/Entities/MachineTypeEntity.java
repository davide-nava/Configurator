package com.configurator.Entities;

import java.util.Date;
import java.util.UUID;

public class MachineTypeEntity implements IBaseEntity {

    private UUID machineTypeId = UUID.randomUUID();
    private String name = "";
    private String desc = "";
    private String code = "";
    private String nr = "";
    private Date dt;
    private String img = "";
    private int axes = 1;
    private String cnc = "";
    private String note = "";
    private int spidles = 1;

    @Override
    public String getPk() {
        return "MachineTypeId";
    }

    @Override
    public String getTable() {
        return "MachineType";
    }

    public MachineTypeEntity(UUID machineTypeId, String name, String desc, String code, String nr, Date dt, String img,
            int axes, String cnc, String note, int spidles) {

        this.machineTypeId = machineTypeId;
        this.name = name;
        this.desc = desc;
        this.code = code;
        this.nr = nr;
        this.dt = dt;
        this.img = img;
        this.axes = axes;
        this.cnc = cnc;
        this.note = note;
        this.spidles = spidles;
    }

    public UUID getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(UUID machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getSpidles() {
        return spidles;
    }

    public void setSpidles(int spidles) {
        this.spidles = spidles;
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
