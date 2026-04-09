package com.javalearning;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) {
        // Change this to the full path of your file
        String filename = "C:\\Users\\HP\\Downloads\\file.txt";

        // Writing (append mode: true means add instead of overwrite)
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("\nThis code is written by Shriya Gupta");
            System.out.println("Data appended to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Reading from the file
        try (FileReader reader = new FileReader(filename);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            System.out.println("\nReading data from file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

