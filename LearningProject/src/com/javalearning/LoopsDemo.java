package com.javalearning;


public class LoopsDemo {
	
	//Sum using for loop
	public int sumUsingForLoop(int n) {
		int sum = 0;
		for(int i=1; i<=n;i++) {
			sum +=i;
		}
		return sum;
	}
	
	//Sum using while loop
	public int sumUsingWhileLoop(int n) {
		int sum = 0;
		int i = 1;
		while(i <=n) {
			sum +=i;
			i++;
		}
		return sum;
		
	}
	
	// Subtraction using for loop (start from n and subtract down to 1)
    public int subtractUsingForLoop(int n) {
        int result = n;
        for (int i = n - 1; i >= 1; i--) {
            result -= i;
        }
        return result;
    }

    // Subtraction using while loop
    public int subtractUsingWhileLoop(int n) {
        int result = n;
        int i = n - 1;
        while (i >= 1) {
            result -= i;
            i--;
        }
        return result;
    }

	public static void main(String[] args) {
		LoopsDemo demo = new LoopsDemo();
		int n=10;
		int m = 1;
		
		System.out.println("Sum using for loop:: "+demo.sumUsingForLoop(n));
		System.out.println("Sum using while loop:: "+demo.sumUsingWhileLoop(n));
		System.out.println("Subtraction using for loop:: "+demo.subtractUsingForLoop(m));
		System.out.println("Subtraction using for loop:: "+demo.subtractUsingWhileLoop(m));
		

	}

}
