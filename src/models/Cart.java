package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<Product>();
    }

    public Cart(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProductToCart(Product product, int purchasedQuantity) {

        if (product.isExpires() && LocalDate.now().isAfter(product.getExpiryDate())) {
            throw new IllegalArgumentException("Cannot add expired product to cart.");
        }

        product.setPurchasedQuantity(purchasedQuantity);
        products.add(product);
    }

    public boolean isEmpty() {
        return products == null || products.isEmpty();
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product: products) {
            totalPrice += product.getPrice() * product.getPurchasedQuantity();
        }
        return totalPrice;
    }

    public double getTotalWeight() {
        double totalWeight = 0.0;
        for (Product product: products) {
            if (product.isShippable()) {
                totalWeight += product.getWeight() * product.getPurchasedQuantity();
            }
        }

        return totalWeight;
    }

}
