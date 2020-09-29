package com.example.user_management_system.model;

public class Customer {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
    private String created_date;

    public Customer() {
        this.id = null;
        this.name = null;
        this.phoneNumber = null;
        this.address = null;
        this.created_date = null;
    }

    public Customer(Integer id, String name, String phoneNumber, String address, String created_date) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.created_date = created_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
