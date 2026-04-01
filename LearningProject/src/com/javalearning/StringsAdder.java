package com.javalearning;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringsAdder {

	@Test
	public void testaddString() {
		StringAdd sa = new StringAdd();
		assertEquals("onetwo", sa.add("one", "two"));
		//fail("Not yet implemented");
	}
	public class StringAdd {
		public String add(String one, String two) {
			return one + two ;

		}
	}
}
