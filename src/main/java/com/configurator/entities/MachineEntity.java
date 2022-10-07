package com.configurator.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class MachineEntity implements Serializable {

    public static final String PK = "MachineId";
    public static final String TABLE = "Machine";
    private UUID machineId;
    private UUID machineTypeId;
    private String code = "";
    private String desc = "";
    private String doc = "";
    private String note = "";
    private String productionOrder = "";
    private String address = "";
    private Date dtDelivery;
    private Date dtAcceptance;
    private Date dtEndWarranty;
    private Date dtStartWarranty;
    private int nr = 1;
    private int year = 2022;
    private float basePrice = 1;

    public UUID getMachineId() {
        return machineId;
    }

    public void setMachineId(UUID machineId) {
        this.machineId = machineId;
    }

    public UUID getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(UUID machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(String productionOrder) {
        this.productionOrder = productionOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDtDelivery() {
        return dtDelivery;
    }

    public void setDtDelivery(Date dtDelivery) {
        this.dtDelivery = dtDelivery;
    }

    public Date getDtAcceptance() {
        return dtAcceptance;
    }

    public void setDtAcceptance(Date dtAcceptance) {
        this.dtAcceptance = dtAcceptance;
    }

    public Date getDtEndWarranty() {
        return dtEndWarranty;
    }

    public void setDtEndWarranty(Date dtEndWarranty) {
        this.dtEndWarranty = dtEndWarranty;
    }

    public Date getDtStartWarranty() {
        return dtStartWarranty;
    }

    public void setDtStartWarranty(Date dtStartWarranty) {
        this.dtStartWarranty = dtStartWarranty;
    }

}
