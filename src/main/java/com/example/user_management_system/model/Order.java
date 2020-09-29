package com.example.user_management_system.model;

public class Order {
    private Integer id;
    private Product product;
    private Integer quantity;
    private Integer totalPrice;
    private String buyer;
    private String email;
    private String address;

    public Order(){
        this.id = null;
        this.product = null;
        this.quantity = null;
        this.totalPrice = null;
        this.buyer = null;
        this.email = null;
        this.address = null;
    }

    public Order(Integer id, Product product, Integer quantity, Integer totalPrice, String buyer, String email, String address) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.buyer = buyer;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product.toString() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", buyer='" + buyer + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
