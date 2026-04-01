package com.javatesting;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestAdder {

    // Method to add two strings together 
    public String add(String a, String b) {
        return a + b;   // simply join the two strings
    }
        public String add(String a, String b, String c) {
    	return a + b + c;
    }

    @Test
    public void testaddtwostrings() {
        TestAdder sa = new TestAdder();
        assertEquals("twothree", sa.add("two", "three"));
    }
    @Test
    public void testaddthreestrings() {
    	TestAdder sa = new TestAdder();
    	assertEquals("twothreefour", sa.add("two", "three", "four"));
    }
}
