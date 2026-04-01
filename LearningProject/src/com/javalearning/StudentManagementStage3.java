//This program demonstrates Collections using ArrayList and Collections
package com.javalearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class StudentData {
    private int id;
    private String name;
    private int marks;

    public StudentData(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getMarks() { return marks; }

    public void printStudentData() {
        System.out.println(id + " - " + name + " - " + marks);
    }

	
}

public class StudentManagementStage3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentData> StudentDatas = new ArrayList<>();

        System.out.print("Enter number of Students: ");
        int n = sc.nextInt();

        // Add StudentDatas to ArrayList
        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            StudentDatas.add(new StudentData(id, name, marks));
        }

        // Print all StudentDatas
        System.out.println("\n--- StudentData List ---");
        for (StudentData s : StudentDatas) {
            s.printStudentData();
        }

        // Sort StudentDatas by marks (Rank List)
        Collections.sort(StudentDatas, Comparator.comparingInt(StudentData::getMarks).reversed());

        System.out.println("\n--- Rank List ---");
        int rank = 1;
        for (StudentData s : StudentDatas) {
            System.out.println(rank++ + ". " + s.getName() + " - " + s.getMarks());
        }

        sc.close();
    }
}
