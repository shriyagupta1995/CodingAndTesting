package com.javalearning;

//Step 1: Define a functional interface
@FunctionalInterface
interface MyFunctionalInterface {
 void greet(String name);
}

public class FunctionalInterfaceDemo {
 public static void main(String[] args) {
     // Step 2: Implement the interface using a lambda expression
     MyFunctionalInterface greeter = (name) -> {
         System.out.println("Hello, " + name + "!");
     };

     // Step 3: Use the functional interface
     greeter.greet("Alice");
     greeter.greet("Bob");
 }
}
