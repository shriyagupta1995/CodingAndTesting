//This program demonstrates OOPS concepts.
package com.javalearning;

import java.util.Scanner;

public class StudentManagementStage2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];
        GraduateStudent[] gs = new GraduateStudent[n];

        // Create Student objects
        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            students[i] = new Student(id, name, marks);
        }

        // Print all students
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.printStudent();
        }

        sc.close();
    }
}
