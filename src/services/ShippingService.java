package services;

import models.Customer;
import models.Product;

public class ShippingService {
    private double shippingRate;

    public ShippingService(double shippingRate) {
        this.shippingRate = shippingRate;
    }

    public double getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(double shippingRate) {
        if (shippingRate < 0.0) {
            throw new IllegalArgumentException("Shipping rate must not be a negative number.");
        }
        this.shippingRate = shippingRate;
    }

    public double calculateShippingCost(double weight) {
        if (weight < 0.0) {
            throw new IllegalArgumentException("Weight must not be a negative number.");
        }
        return weight * shippingRate; // assuming shippingRate is per kg
    }



    public void checkout(Customer customer) {
        double totalPrice = customer.getCart().getTotalPrice();
        double totalWeight = customer.getCart().getTotalWeight() / 1000;

        System.out.println("** Shipment notice **");
        for (Product product: customer.getCart().getProducts()) {
            if (product.isShippable()) {
                System.out.println(product.getPurchasedQuantity() +"x " + product.getName()+"      "+product.getWeight() * product.getPurchasedQuantity()+"g");
            }
        }
        System.out.println("Total package weight: " + customer.getCart().getTotalWeight() / 1000 + "kg");
        System.out.println();
        System.out.println();


        System.out.println("** Checkout receipt **");
        for (Product product: customer.getCart().getProducts()) {
            System.out.println(product.getPurchasedQuantity() + "x " + product.getName() + "      " + product.getPrice() * product.getPurchasedQuantity());
        }
        System.out.println("-------------------------");
        System.out.println("Subtotal: " + totalPrice);
        System.out.println("Shipping: " + calculateShippingCost(totalWeight));
        System.out.println("Amount: "+ (totalPrice + totalWeight));
    }
}
