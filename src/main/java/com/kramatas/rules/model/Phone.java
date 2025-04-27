package com.kramatas.rules.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private String model;
    private String brand;           // Changed from Brand class to String
    private String deal;            // Changed from Deal class to String
    private String network;         // Changed from Network class to String
    private String operatingSystem; // Changed from OperatingSystem class to String
    private String simType;         // Changed from SIMType class to String

    public Phone() {
    }

    public Phone(String model, String brand, String deal, String network, String operatingSystem, String simType) {
        this.model = model;
        this.brand = brand;
        this.deal = deal;
        this.network = network;
        this.operatingSystem = operatingSystem;
        this.simType = simType;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }
}
