package com.configurator.Entities;

import java.io.Serializable;

public class MachineViewModel extends MachineEntity implements Serializable {

    private String machineTypeDesc = "";

    public String getMachineTypeDesc() {
        return machineTypeDesc;
    }

    public void setMachineTypeDesc(String machineTypeDesc) {
        this.machineTypeDesc = machineTypeDesc;
    }

}
