//This program demonstrates java basics (Variables, Data types, Control flow, Loops, Arrays)
import java.util.Scanner;

public class StudentManagementStage1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Step 2: Create arrays
        String[] names = new String[n];
        int[] marks = new int[n];

        // Step 3: Input student data
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i+1) + ": ");
            names[i] = sc.next();
            System.out.print("Enter marks of " + names[i] + ": ");
            marks[i] = sc.nextInt();
        }

        // Step 4: Print student list
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }

        // Step 5: Calculate average
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        double average = (double) sum / n;
        System.out.println("\nAverage Marks = " + average);

        // Step 6: Find highest and lowest marks
        int highest = marks[0];
        int lowest = marks[0];
        String topStudent = names[0];
        String bottomStudent = names[0];

        for (int i = 1; i < n; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
                topStudent = names[i];
            }
            if (marks[i] < lowest) {
                lowest = marks[i];
                bottomStudent = names[i];
            }
        }

        System.out.println("Highest Marks = " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Marks = " + lowest + " (by " + bottomStudent + ")");

        sc.close();

    }
}
