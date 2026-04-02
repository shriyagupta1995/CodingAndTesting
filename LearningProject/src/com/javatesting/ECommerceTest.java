package com.javatesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class ECommerceTest {

    private ShoppingCart cart;
    private Product laptop;
    private Product phone;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        laptop = new Product("Laptop", 1000.0);
        phone = new Product("Phone", 500.0);
    }

    //This test will fail as I have added 2 in "assertEquals" but there is only 1 product
    @Test
    void testAddProductToCart() {
        cart.addProduct(laptop);
        assertEquals(2, cart.getProducts().size(), "Cart should contain 1 product");
        assertTrue(cart.getProducts().contains(laptop), "Laptop should be in the cart");
    }

    @Test
    void testRemoveProductFromCart() {
        cart.addProduct(laptop);
        cart.removeProduct(laptop);
        assertEquals(0, cart.getProducts().size(), "Cart should be empty after removal");
    }

    //This test will fail as the sum of both products is 1500 but I have added 1600
    @Test
    void testCartTotalPrice() {
        cart.addProduct(laptop);
        cart.addProduct(phone);
        assertEquals(1600.0, cart.getTotalPrice(), "Total price should be sum of products");
    }

    @Test
    void testCheckoutWithEmptyCart() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            cart.checkout();
        });
        assertEquals("Cart is empty!", exception.getMessage());
    }

    @Test
    void testSuccessfulCheckout() {
        cart.addProduct(laptop);
        String receipt = cart.checkout();
        assertTrue(receipt.contains("Laptop"), "Receipt should list purchased product");
        assertTrue(receipt.contains("Total: 1000.0"), "Receipt should show correct total");
    }
}

// Supporting classes
class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() { return name; }
    double getPrice() { return price; }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

    List<Product> getProducts() {
        return products;
    }

    double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    String checkout() {
        if (products.isEmpty()) {
            throw new RuntimeException("Cart is empty!");
        }
        StringBuilder receipt = new StringBuilder("Receipt:\n");
        for (Product p : products) {
            receipt.append(p.getName()).append(" - ").append(p.getPrice()).append("\n");
        }
        receipt.append("Total: ").append(getTotalPrice());
        products.clear(); // empty cart after checkout
        return receipt.toString();
    }
}
