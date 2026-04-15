package com.javalearning;

public class Pattern {
	public static void main(String[] args) {
		Pattern P= new Pattern();
		int n = 4;
		int m = 5;
		// Outer Loop
		for(int i=1; i<=n; i++) {
			// Inner loop
			for(int j=1; j<=m; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// Print hollow rectangle pattern
		int k = 4;
		int l = 5;
			//outer loop
			for(int i=1; i<=k; i++) {
				// Inner loop
				for(int j=1; j<=l; j++) {
					//cell(i,j)
					if(i == 1 || j == 1 || i == k || j == l) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();

			}
			//Print half pyramid
			int o=4;
			//outer loop
			for (int i=1; i<=o; i++) {
			//Inner loop
			for (int j=1; j<=i; j++) {
				System.out.print("*");
				}
			    System.out.println(" ");
			}
			//Inverted Half Pyramid
	        int p=4;
			//outer loop
			for (int i=p; i>=1; i--) {
		    //inner loop
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			    System.out.println(" ");
			}
         // print half pyramid rotated by 180 degree
			int q=4;
			//outer loop
			for (int i=1; i<=q; i++) {
			//inner loop - space print
			for ( int j=1; j<=q-i; j++) {
				System.out.print(" ");
			}
			//inner loop - Star print
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
			}
		// half  pyramid with numbers
			int r=5;
		//outer loop
			for (int i=1; i<=r; i++) {
		//Inner loop
			for (int j=1; j<=i; j++) {	
				System.out.print(j+" ");
			}
			System.out.println(" ");
			}
	//inverted half pyramid with numbers
			int t=5;
			// outer loop
			for(int i=1; i<=t; i++){
			//inner loop
			for (int j=1; j<=t-i+1; j++){
				System.out.print(j);				
			}
			System.out.println(" ");
			}
			
			// Floyd's triangle
			int u=5;
			int number = 1;
			// outer loop
			for(int i=1; i<=u; i++){
			//inner loop
			for(int j=1; j<=i; j++){
			System.out.print(number+" ");
			number++;  //number = number+1
	}
			System.out.println();
	}
}
}

