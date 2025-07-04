package models;

public class Customer {

    // Attributes
    private String customerName;
    private String customerEmail;
    private Cart cart;
    private double customerBalance;

    // Constructors
    public Customer() {}

    public Customer(String customerName, String customerEmail, double customerBalance) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.cart = new Cart();
        this.customerBalance = customerBalance;
    }

    public Customer(String customerName, String customerEmail, Cart cart) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.cart = cart;
    }

    // Getters
    public String getCustomerName() {
        return this.customerName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public Cart getCart() {
        return this.cart;
    }

    public double getCustomerBalance() {
        return this.customerBalance;
    }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCustomerBalance(double customerBalance) {
        if (customerBalance < 0.0) {
            throw new IllegalArgumentException("Customer balance must not be a negative number.");
        }
        this.customerBalance = customerBalance;
    }



}
