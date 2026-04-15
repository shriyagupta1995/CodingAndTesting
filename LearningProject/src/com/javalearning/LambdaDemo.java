package com.javalearning;

//Functional interface
@FunctionalInterface
interface MyFunctionalInterface {
 void sayMessage(String message);
}

public class LambdaDemo {
 public static void main(String[] args) {
     // Using a lambda expression to implement the interface
     MyFunctionalInterface myLambda = (msg) -> {
         System.out.println("Message: " + msg);
     };

     // Call the method
     myLambda.sayMessage("Hello, Lambda Expressions in Java!");
 }
}

