package services;

import models.Customer;

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
        return weight * shippingRate;
    }



    public void checkout(Customer customer) {

    }
}
