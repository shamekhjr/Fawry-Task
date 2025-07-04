package models;

public class Customer {

    // Attributes
    private String customerName;
    private String customerEmail;
    private Cart cart;

    // Constructors
    public Customer() {}

    public Customer(String customerName, String customerEmail) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.cart = new Cart();
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



}
