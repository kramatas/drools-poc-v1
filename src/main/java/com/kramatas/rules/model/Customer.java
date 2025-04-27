package com.kramatas.rules.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Customer {

    @Id
    private String id;
    private String name;
    private int age;
    private int yearsWithCompany;
    private int discount;

    public Customer() {}

    public Customer(String id, String name, int age, int yearsWithCompany) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.yearsWithCompany = yearsWithCompany;
        this.discount = 0;
    }

    // Getters and Setters

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getYearsWithCompany() { return yearsWithCompany; }

    public void setYearsWithCompany(int yearsWithCompany) {
        this.yearsWithCompany = yearsWithCompany;
    }

    public int getDiscount() { return discount; }

    public void setDiscount(int discount) { this.discount = discount; }
}
