package models;

import interfaces.Shippable;

import java.time.LocalDate;

public class Product implements Shippable {

    // Attributes
    private String productName;
    private double price;
    private int purchasedQuantity;
    private int stock;
    private boolean expires;
    private LocalDate expiryDate;
    private boolean shippable;
    private double weight;

    // Constructors
    public Product() {

    }

    public Product(String productName, double price, int stock, int purchasedQuantity, boolean expires, LocalDate expiryDate, boolean shippable, double weight) {
        this.productName = productName;
        this.price = price;
        this.purchasedQuantity = purchasedQuantity;
        this.expires = expires;
        this.stock = stock;
        this.expiryDate = expiryDate;
        this.shippable = shippable;
        this.weight = weight;

    }


    // Interface methods
    @Override
    public String getName() {
        return this.productName;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    public int getStock() {
        return this.stock;
    }

    // Getters
    public double getPrice() {
        return this.price;
    }

    public int getPurchasedQuantity() {
        return this.purchasedQuantity;
    }

    public boolean isExpires() {
        return this.expires;
    }

    public boolean isShippable() {
        return this.shippable;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    // Setters
    public void setProductName(String name) {
        this.productName = name;
    }

    public void setWeight(double weight) {
        if (weight <= 0.0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }

        this.weight = weight;
    }

    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price must not be a negative number.");
        }
        this.price = price;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        if (purchasedQuantity < 0) {
            throw new IllegalArgumentException("Quantity must not be a negative number.");
        }

        if (purchasedQuantity > stock) {
            throw new IllegalArgumentException("Not enough items remaining in stock.");
        }

        this.purchasedQuantity = purchasedQuantity;
    }



}
