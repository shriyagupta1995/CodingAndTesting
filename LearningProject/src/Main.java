//This example shows method overriding

public class Main {

	public static void main(String[] args) {
		String q = null;
		Vehicle v1= new Car();
		Car c = new Car();
		v1.displayInfo();
		c.displayInfo(q);
		Vehicle v2 = new Bike();
		v2.displayInfo();
		Vehicle v3 = new Bus();
		v3.displayInfo();

	}

}

class Vehicle{
	public void displayInfo(){
		System.out.println("Some vehicles are there");
		
	}
}

class Car extends Vehicle{

	@Override
	public void displayInfo() {
		System.out.println("I have a car");
	}
	
	public void displayInfo(String v) {
		v = "I have a truck";
		System.out.println(v);
	}
	
}
class Bike extends Vehicle{

	@Override
	public void displayInfo() {
		System.out.println("I have a Bike");
	}
	
}
class Bus extends Vehicle{

	@Override
	public void displayInfo() {
		System.out.println("I have a Bus");
		
	}
	
}
