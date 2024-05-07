package com.example.logistic_dashboardapi.DTO;

import java.math.BigDecimal;

public class OrderDto {
    private String skuCode;
    private String quantity;
    private BigDecimal price;
    private String nameOfPerson;
    private String phone;
    private String address;
    private String company;

    // Getter and Setter methods for skuCode
    public String getSkuCode() {
        return skuCode;
    }
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    // Getter and Setter methods for quantity
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter methods for Price
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Getter and Setter methods for NameOfPerson
    public String getNameOfPerson() {
        return nameOfPerson;
    }
    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    // Getter and Setter methods for Phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and Setter methods for Address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter methods for CompanyName
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
}
