package com.loantracker.loantracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shopkeepers")
public class Shopkeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shopName;

    @Column(unique = true)
    private String mobile;

    private String password;
    private String role;
    private String location;

    // Constructors
    public Shopkeeper() {}

    public Shopkeeper(Long id, String name, String shopName, String mobile, String password, String role, String location) {
        this.id = id;
        this.name = name;
        this.shopName = shopName;
        this.mobile = mobile;
        this.password = password;
        this.role = role;
        this.location = location;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}