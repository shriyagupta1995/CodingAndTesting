package com.javalearning;

public class Student {
    protected int id;
    protected String name;
    protected int marks;

    // Constructor
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter methods (Encapsulation)
    public int getId() { 
    	return id; 
    	}
    public String getName() {
    	return name; 
    	}
    public int getMarks() { 
    	return marks; 
    	}

    // Business logic method
    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "D";
    }

    // Display method
    public void printStudent() {
        System.out.println(id + " - " + name + " - " + marks + " (" + calculateGrade() + ")");
    }
}
