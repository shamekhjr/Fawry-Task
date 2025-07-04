import models.Customer;
import models.Product;

public class Main {


    public static void main(String[] args) {

        // Create products
        Product apple = new models.Product(
                "Apple", 0.5, 100, 0, true,
                java.time.LocalDate.now().plusDays(5), false, 0.0);

        Product laptop = new models.Product(
                "Laptop", 1200.0, 10, 0, false,
                null, true, 2000.0); // 2kg

        Product book = new models.Product(
                "Book", 20.0, 50, 0, false,
                null, true, 500.0); // 0.5kg

        // Create customer
        Customer customer = new models.Customer("Alice", "alice@example.com", 5000.0);

        // Add products to cart
        customer.getCart().addProductToCart(apple, 6);   // Not shippable
        customer.getCart().addProductToCart(laptop, 1);  // Shippable
        customer.getCart().addProductToCart(book, 3);    // Shippable

        // Create shipping service with rate per kg
        services.ShippingService shippingService = new services.ShippingService(10.0);

        // Checkout
        shippingService.checkout(customer);

    }
}
