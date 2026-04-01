package com.javalearning;

public class RangeBoundaryTestDemo {
    public static void main(String[] args) {
        System.out.println("=== Range Testing ===");
        int[] rangeTestCases = {25, 50, 75}; // values spread across the range
        for (int age : rangeTestCases) {
            System.out.println("Age " + age + " valid? " + AgeValidator.isValidAge(age));
        }

        System.out.println("\n=== Boundary Testing ===");
        int[] boundaryTestCases = {0, 1, 2, 99, 100, 101}; // edge and just outside values
        for (int age : boundaryTestCases) {
            System.out.println("Age " + age + " valid? " + AgeValidator.isValidAge(age));
        }
    }
}

class AgeValidator {
    // Valid age range: 1 to 100
    public static boolean isValidAge(int age) {
        return age >= 1 && age <= 100;
    }
}
