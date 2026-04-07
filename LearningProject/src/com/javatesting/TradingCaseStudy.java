package com.javatesting;

// TradingCaseStudy.java
// A complete trading domain case study with JUnit tests

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// --- Domain Classes ---

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

class Portfolio {
    private double balance;
    private Map<String, Integer> holdings;

    public Portfolio(double balance) {
        this.balance = balance;
        this.holdings = new HashMap<>();
    }

    public double getBalance() { return balance; }
    public Map<String, Integer> getHoldings() { return holdings; }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.getSymbol(),
                holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
        } else {
            throw new IllegalArgumentException("Insufficient balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int currentQty = holdings.getOrDefault(stock.getSymbol(), 0);
        if (quantity <= currentQty) {
            balance += stock.getPrice() * quantity;
            holdings.put(stock.getSymbol(), currentQty - quantity);
        } else {
            throw new IllegalArgumentException("Not enough stock to sell!");
        }
    }
}

// --- JUnit Test Cases ---

public class TradingCaseStudy {

    @Test
    public void testBuyStock() {
        Portfolio portfolio = new Portfolio(1000);
        Stock apple = new Stock("AAPL", 100);

        portfolio.buyStock(apple, 5);

        assertEquals(500, portfolio.getBalance());
        assertEquals(5, portfolio.getHoldings().get("AAPL"));
    }

    @Test
    public void testSellStock() {
        Portfolio portfolio = new Portfolio(1000);
        Stock google = new Stock("GOOG", 200);

        portfolio.buyStock(google, 3); // cost = 600
        portfolio.sellStock(google, 2); // gain = 400

        assertEquals(800, portfolio.getBalance()); // 1000 - 600 + 400
        assertEquals(1, portfolio.getHoldings().get("GOOG"));
    }

    @Test
    public void testBuyStockInsufficientBalance() {
        Portfolio portfolio = new Portfolio(100);
        Stock tesla = new Stock("TSLA", 500);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            portfolio.buyStock(tesla, 1);
        });

        assertEquals("Insufficient balance!", exception.getMessage());
    }

    @Test
    public void testSellStockNotEnoughQuantity() {
        Portfolio portfolio = new Portfolio(1000);
        Stock amazon = new Stock("AMZN", 300);

        portfolio.buyStock(amazon, 1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            portfolio.sellStock(amazon, 2);
        });

        assertEquals("Not enough stock to sell!", exception.getMessage());
    }
}
