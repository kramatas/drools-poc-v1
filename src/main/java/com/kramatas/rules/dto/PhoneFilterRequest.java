package com.kramatas.rules.dto;

public class PhoneFilterRequest {
    private String deal;
    private String network;
    private String simType;
    private String brand;  // Added brand field
    private String operatingSystem;
    private String model;

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }


    public String getDeal() { return deal; }
    public void setDeal(String deal) { this.deal = deal; }

    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public String getSimType() { return simType; }
    public void setSimType(String simType) { this.simType = simType; }

    public String getBrand() { return brand; }  // Added getter for brand
    public void setBrand(String brand) { this.brand = brand; }  // Added setter for brand

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}

