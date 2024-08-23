package com.example.projectSupplier;

import java.util.List;

public class Supplier {
    private String location;
    private String natureOfBusiness;
    private List<String> manufacturingProcesses;

    // Getters and setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public List<String> getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(List<String> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }
}
