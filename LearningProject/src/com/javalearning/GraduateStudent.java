package com.javalearning;


public class GraduateStudent extends Student {
	
	String thesisTitle;

	public GraduateStudent(int id, String name, int marks) {
		super(id, name, marks);
		this.thesisTitle = thesisTitle;
	}

	/**
	 * @return the thesisTitle
	 */
	public String getThesisTitle() {
		return thesisTitle;
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
        System.out.println(id + " - " + name + " - " + marks + " (" + calculateGrade() + ")"+ thesisTitle + "-");
    }
	
	

}
