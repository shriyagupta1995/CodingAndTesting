import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTestUsingSwitchCase {

	@Test
	void testAddition() {
		Calculator calc = new Calculator();
		assertEquals(5, calc.calculate(2, 3, "+"));
	}

	@Test
	void testInvalidOperation() {
		Calculator calc = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> calc.calculate(2, 3, "%"));
	}

	@Test
	void testSubtraction() {
		Calculator calc = new Calculator();
		assertEquals(1, calc.calculate(3, 2, "-"));
	}

	@Test
	void testMultiplication() {
		Calculator calc = new Calculator();
		assertEquals(6, calc.calculate(2, 3, "*"));
	}

	@Test
	void testDivision() {
		Calculator calc = new Calculator();
		assertEquals(2, calc.calculate(6, 3, "/"));
	}
}

class Calculator {
	public int calculate(int a, int b, String operator) {
		switch (operator) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			if (b == 0) throw new ArithmeticException("Division by zero");
			return a / b;
		default:
			throw new IllegalArgumentException("Invalid operator");
		}
	}
}