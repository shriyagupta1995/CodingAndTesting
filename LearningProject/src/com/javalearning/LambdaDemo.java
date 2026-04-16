package com.javalearning;

//Functional interface
@FunctionalInterface
interface MyFunctionalInterfacelambda {
 void sayMessage(String message);
}

public class LambdaDemo {
 public static void main(String[] args) {
     // Using a lambda expression to implement the interface
     MyFunctionalInterfacelambda myLambda = (msg) -> {
         System.out.println("Message: " + msg);
     };

     // Call the method
     myLambda.sayMessage("Hello, Lambda Expressions in Java!");
 }
}

