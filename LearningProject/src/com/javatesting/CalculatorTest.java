package com.javatesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//TDD is shown in this example as I am writing unit tests for calculator and shapes class
class CalculatorTest {

	@Test
	public void testAddition() {
		Calculator calc = new Calculator();
		Shapes sh = new Shapes();
		assertEquals(5, calc.add(2, 3));
		assertEquals(10, calc.add(5, 3, 2));
		assertEquals(16, sh.area(4));
		assertEquals(12, sh.area(3,4));
		//fail("Not yet implemented");
	}
	
	//This class also shows method overloading in action as I have created 2 methods
	//with same name
	public class Calculator{
		public int add(int a, int b) {
			return a+b;
		}
		public int add(int c, int d, int e) {
			return c+d+e;
		}
	}
	
	//This class also shows method overloading in action as I have created 2 methods
	//with same name
	public class Shapes{
		//To calculate area of square
		public int area(int s) {
			return s*s;
		}
		
		// To calculate area of rectangle
		public int area(int l, int b) {
			return l*b;
		}
	}

}
