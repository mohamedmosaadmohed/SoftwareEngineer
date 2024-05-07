package com.example.logistic_dashboardapi.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String sku_code;
    private String quantity;
    private Double price;
    private String name_of_person;
    private String phone;
    private String address;
    private String company;
    private LocalDateTime Create_Date;

    // Getter and Setter methods for Id
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    // Getter and Setter methods for skuCode
    public String getSkuCode() {
        return sku_code;
    }
    public void setSkuCode(String skuCode) {
        this.sku_code = skuCode;
    }

    // Getter and Setter methods for quantity
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter methods for Price
    public Double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getNameOfPerson() {
        return name_of_person;
    }
    public void setNameOfPerson(String nameOfPerson) {
        this.name_of_person = nameOfPerson;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public LocalDateTime getCreateDate() {
        return Create_Date;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.Create_Date = createDate;
    }
}

