package com.javalearning;

//Main class
public class PizzaInheritanceDemo {
	public static void main(String[] args) {
		Pizza basicPizza = new Pizza("Medium", 200.00);
		VegPizza vegPizza = new VegPizza("Large", 400.00, "Olives & Capsicum");
		CheesePizza cheesePizza = new CheesePizza("Small", 100.00, 2);

		System.out.println("=== Basic Pizza ===");
		basicPizza.displayInfo();

		System.out.println("\n=== Veg Pizza ===");
		vegPizza.displayInfo();

		System.out.println("\n=== Cheese Pizza ===");
		cheesePizza.displayInfo();
	}
}

//Base class
class Pizza {
	String size;
	double price;

	Pizza(String size, double price) {
		this.size = size;
		this.price = price;
	}

	void displayInfo() {
		System.out.println("Pizza size: " + size);
		System.out.println("Base price: Rs " + price);
	}
}

//Derived class 1
class VegPizza extends Pizza {
	String topping;

	VegPizza(String size, double price, String topping) {
		super(size, price); // call parent constructor
		this.topping = topping;
	}

	@Override
	void displayInfo() {
		super.displayInfo(); // reuse parent method
		System.out.println("Veg topping: " + topping);
	}
}

//Derived class 2
class CheesePizza extends Pizza {
	int extraCheeseLayers;

	CheesePizza(String size, double price, int extraCheeseLayers) {
		super(size, price);
		this.extraCheeseLayers = extraCheeseLayers;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Extra cheese layers: " + extraCheeseLayers);
	}
}

