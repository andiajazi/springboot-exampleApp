package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class OwnerDto extends CustomerDto {
    private Integer licenceNumber;
    private Integer accountNumber;
    private List<PropertyDto> properties = new ArrayList<>();

    public OwnerDto(String firstName, String lastName, Integer age, ContactDto contact,
                    Integer licenceNumber, Integer accountNumber, List<PropertyDto> properties) {
        super(firstName, lastName, age, contact);
        this.accountNumber = accountNumber;
        this.licenceNumber = licenceNumber;
        this.properties = properties;

    }

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

    public List<PropertyDto> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDto> properties) {
        this.properties = properties;
    }
}
