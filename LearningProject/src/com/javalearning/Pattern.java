package com.javalearning;

public class Pattern {
	public static void main(String[] args) {
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
		}

	}



