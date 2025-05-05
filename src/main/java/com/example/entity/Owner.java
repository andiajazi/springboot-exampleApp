package com.example.entity;

import jakarta.persistence.*;
import jakarta.websocket.OnError;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class Owner extends Customer {


    private Integer licenceNumber;
    private Integer accountNumber;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "owner")
//    @JoinColumn(name = "property_id")
    private List<Property> properties;

    public Integer getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Integer licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
