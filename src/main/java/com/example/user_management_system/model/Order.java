package com.example.user_management_system.model;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="total_price")
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(Integer id, Product product, Integer quantity, Integer totalPrice, Customer customer) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    // Getter and Setter
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product.toString() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer.toString() +
                '}';
    }
}
