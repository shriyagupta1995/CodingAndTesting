//Updated this code to add some bugs.

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

    // BUG: allows negative price without validation
    public void setPrice(double price) {
        this.price = price;
    }
}

class Portfolio {
    private double balance;
    private Map<String, Integer> holdings = new HashMap<>();

    public Portfolio(double balance) {
        this.balance = balance;
    }

    public double getBalance() { return balance; }
    public Map<String, Integer> getHoldings() { return holdings; }

    // BUG: does not check for negative quantity
    // BUG: uses < instead of <= for balance check
    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost < balance) {
            balance -= cost;
            holdings.put(stock.getSymbol(),
                holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
        } else {
            throw new IllegalArgumentException("Insufficient balance!");
        }
    }

    // BUG: selling increases holdings instead of reducing them
    public void sellStock(Stock stock, int quantity) {
        int currentQty = holdings.getOrDefault(stock.getSymbol(), 0);
        if (quantity <= currentQty) {
            balance += stock.getPrice() * quantity;
            holdings.put(stock.getSymbol(), currentQty + quantity); // should subtract
        } else {
            throw new IllegalArgumentException("Not enough stock to sell!");
        }
    }
}

// --- JUnit Test Cases ---

public class TradingCaseStudy {

	@Test
    public void testNegativeStockPriceNotAllowed() {
        Stock stock = new Stock("AAPL", 100);
        stock.setPrice(-50); // BUG: allowed

        assertTrue(stock.getPrice() >= 0,
            "Stock price should never be negative!");
    }

    @Test
    public void testBuyStockEqualBalance() {
        Portfolio portfolio = new Portfolio(500);
        Stock msft = new Stock("MSFT", 100);

        portfolio.buyStock(msft, 5); // BUG: rejected because of < instead of <=

        assertEquals(0, portfolio.getBalance(),
            "Balance should be zero after buying exactly equal to balance");
        assertEquals(5, portfolio.getHoldings().get("MSFT"),
            "Holdings should reflect purchased quantity");
    }

    @Test
    public void testBuyStockNegativeQuantity() {
        Portfolio portfolio = new Portfolio(1000);
        Stock google = new Stock("GOOG", 200);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            portfolio.buyStock(google, -3); // BUG: allowed
        });

        assertEquals("Quantity must be positive!", exception.getMessage(),
            "Should throw exception when buying with negative quantity");
    }

    @Test
    public void testSellStockReducesQuantity() {
        Portfolio portfolio = new Portfolio(1000);
        Stock amazon = new Stock("AMZN", 300);

        portfolio.buyStock(amazon, 2);
        portfolio.sellStock(amazon, 1); // BUG: increases holdings instead of reducing

        assertEquals(1, portfolio.getHoldings().get("AMZN"),
            "Holdings should reduce after selling");
    }
}
