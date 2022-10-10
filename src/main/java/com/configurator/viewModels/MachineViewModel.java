package com.configurator.viewModels;

import com.configurator.entities.MachineEntity;

import java.io.Serializable;

public class MachineViewModel extends MachineEntity implements Serializable {

    private String machineTypeDesc = "";
    private String customerDesc = "";

    public String getMachineTypeDesc() {
        return machineTypeDesc;
    }

    public void setMachineTypeDesc(String machineTypeDesc) {
        this.machineTypeDesc = machineTypeDesc;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

}
