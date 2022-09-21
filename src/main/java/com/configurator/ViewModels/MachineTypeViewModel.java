package com.configurator.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class MachineTypeViewModel implements Serializable{
private static final long serialVersionUID = 1L;
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
