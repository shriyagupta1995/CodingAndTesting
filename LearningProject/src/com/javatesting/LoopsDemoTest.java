package com.javatesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.javalearning.LoopsDemo;

class LoopsDemoTest {
	LoopsDemo demo = new LoopsDemo();

	@Test
	void testSumUsingForLoop() {
		assertEquals(55, demo.sumUsingForLoop(10));
		assertEquals(15, demo.sumUsingForLoop(5));
	}
	
	@Test
	void testSumUsingWhileLoop() {
		assertEquals(60, demo.sumUsingWhileLoop(23));
		assertEquals(100, demo.sumUsingWhileLoop(30));
	}
	
	@Test
    public void testSubtractUsingForLoop() {
        assertEquals(3, demo.subtractUsingForLoop(5));
        assertEquals(0, demo.subtractUsingForLoop(3));
    }

    @Test
    public void testSubtractUsingWhileLoop() {
        assertEquals(3, demo.subtractUsingWhileLoop(5));
        assertEquals(0, demo.subtractUsingWhileLoop(3));
    }


}
