package com.company.books.backend.ejemplos.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertTrueFalseTeoria {

	@Test
	public void test1() {
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	public void test2() {
		boolean expresion = 4 == 4;
		assertTrue(expresion);
	}
}
